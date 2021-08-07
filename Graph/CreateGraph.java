package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CreateGraph {
	private class Node {
		private String label;

		public Node(String label) {
			this.label = label;
		}

		@Override
		public String toString() {

			return label;
		}

	}

	private Map<String, Node> nodes = new HashMap<>();
	private Map<Node, List<Node>> adjacenyList = new HashMap<>();

	public void addNode(String label) {
		var node = new Node(label);
		nodes.putIfAbsent(label, node);
		adjacenyList.putIfAbsent(node, new ArrayList<>());
	}

	public void addEdge(String from, String to) {
		var fromNode = nodes.get(from);
		if (fromNode == null) {
			throw new IllegalArgumentException();

		}
		var toNode = nodes.get(to);
		if (toNode == null) {
			throw new IllegalArgumentException();
		}
		adjacenyList.get(fromNode).add(toNode);
	}

	public void print() {
		for (var source : adjacenyList.keySet()) {
			var target = adjacenyList.get(source);
			if (!target.isEmpty()) {
				System.out.println(source + " is connected to " + target);
			}
		}
	}
	
	public void removeNode(String label) {
		var node = nodes.get(label);
		if(node == null) 
			return;
		for (var n : adjacenyList.keySet()) {
			adjacenyList.get(n).remove(node);
			adjacenyList.remove(node);
			nodes.remove(node);
		}
		
	}
	
	public void removeEdge(String from, String to) {
		var fromNode = nodes.get(from);
		var toNode = nodes.get(to);
		if (fromNode == null || toNode == null) 
			return;
		adjacenyList.get(fromNode).remove(toNode);
	}

	public void traverseDFSrec(String rootVal) {
		var node = nodes.get(rootVal);
		if (node == null) return ;
		traverseDFSrec(node, new HashSet<>());
	}
	
	private void traverseDFSrec(Node root, Set<Node> visited) {
		System.out.println(root);
		visited.add(root);
		for(var node : adjacenyList.get(root)) {
			if(!visited.contains(node)) {
				traverseDFSrec(node, visited);
			}
		}
	}
	
	public void traverseDFSite(String rootval) {
	var node = nodes.get(rootval);
	if (node == null) return ;
	Stack<Node> stack = new Stack<>();
	Set<Node> visited = new HashSet<>();
	stack.push(node);
	while (!stack.isEmpty()) {
		var current = stack.pop();
		if(visited.contains(current))
			continue;
		System.out.println(current);
		visited.add(current);
		
		for (var neighbour : adjacenyList.get(current)) {
			if (!visited.contains(neighbour))
			stack.push(neighbour);
		}
	}

}
	
	public void traverseBFS(String rootval) {
		Node node = nodes.get(rootval);
		if(node == null) return;
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if(visited.contains(curr))
				continue;
			System.out.println(curr);
			
			visited.add(curr);
			for (var neighbour : adjacenyList.get(curr)) {
				if (!visited.contains(neighbour)) {
					queue.add(neighbour);
				}
			}
		}
		
	}

	public List<String> topLogicalSort() {
		
		
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<>();
		for (var node : nodes.values())
			topLogicalSort(node , visited , stack);
		List<String> sorted = new  ArrayList<>();
		while (!stack.isEmpty()) {
			sorted.add(stack.pop().label);
		}
		return sorted;
	}

	private void topLogicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
		if (visited.contains(node)) return;
		visited.add(node);
		for (var neighbour : adjacenyList.get(node))
			topLogicalSort(neighbour,visited,stack);
		
		stack.push(node);
		
	}


}
