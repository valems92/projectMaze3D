package algorithms.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.RandomSelectMethod;
import algorithms.search.BestFirstSearch;
import algorithms.search.CostStateComperator;
import algorithms.search.DepthFirstSearch;
import algorithms.search.Searchable;
import algorithms.search.Searcher;

public class Demo {
	public void run(){
		Maze3dGenerator mg = new GrowingTreeGenerator(new RandomSelectMethod());
		Maze3d maze = mg.generate(4, 6, 7);
		System.out.println("Maze generated: \n" + maze);
		
		Searchable<Position> mazeDomain = new Maze3dDomain(maze);
		
		Searcher<Position> algorithm = new DepthFirstSearch<Position>();
		ArrayList<Position> solution = algorithm.search(mazeDomain);
		
		System.out.println("DepthFirstSearch: " + solution.toString());
		System.out.println("evaluated nodes: " + algorithm.getNumberOfNodesEvaluated() + "\n");
		
		algorithm = new BestFirstSearch<Position>(new CostStateComperator<Position>());
		solution = algorithm.search(mazeDomain);
		
		System.out.println("BestFirstSearch: " + solution.toString());
		System.out.println("evaluated nodes: " + algorithm.getNumberOfNodesEvaluated());
	}
}
