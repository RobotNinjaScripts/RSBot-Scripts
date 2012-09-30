package RoboRunecrafter;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.util.Random;

import RoboRunecrafter.tasks.CheckRune;
import RoboRunecrafter.tasks.GetEssence;
import RoboRunecrafter.tasks.SwapRunes;
import RoboRunecrafter.tasks.WalkToAltar;
import RoboRunecrafter.tasks.EnterAltar;
import RoboRunecrafter.tasks.CraftRunes;
import RoboRunecrafter.tasks.ExitAltar;
import RoboRunecrafter.tasks.WalkToBank;
import RoboRunecrafter.util.Paint;

@Manifest(authors = { "RobotNinja" }, name = "RoboRunecrafter", description = "Crafts runes at almost every altar", version = 0.1, website = "N/A")
public class RoboRunecrafter extends ActiveScript implements PaintListener {

	private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
	private Tree jobContainer = null;

	public final void provide(final Node... jobs) {
		for (final Node job : jobs) {
			jobsCollection.add(job);
		}
		jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
	}

	@Override
	public void onStart() {
		provide(new CheckRune(),
				new GetEssence(),
				new SwapRunes(),
				new WalkToAltar(),
				new EnterAltar(),
				new CraftRunes(),
				new ExitAltar(),
				new WalkToBank());
	}

	@Override
	public int loop() {
		if (jobContainer != null) {
			final Node job = jobContainer.state();
			if (job != null) {
				jobContainer.set(job);
				getContainer().submit(job);
				job.join();
			}
		}
		return Random.nextInt(10, 50);
	}

	@Override
	public void onRepaint(Graphics render) {
		Paint.drawPaintAndCursor(render);
	}

}