package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import org.w3c.dom.Node;

public class WeightedGraph {
	class Node {
		String lable;
		private List<Edge> edges = new ArrayList<>();

		public Node(String lable) {
			this.lable = lable;
		}

		public String toString() {
			return lable;
		}

		public void addEdge(Node to, int weight) {
			edges.add(new Edge(this, to, weight));
		}

		public List<Edge> getEdges() {
			return edges;
		};

	}

	class Edge {
		Node from;
		Node to;
		int Weight;

		public Edge(Node from, Node to, int weight) {
			super();
			this.from = from;
			this.to = to;
			Weight = weight;
		}

		public String toString() {
			return from + "->" + to;
		}

	}

	Map<String, Node> nodes = new HashMap<>();

	public void addNode(String lable) {

		nodes.putIfAbsent(lable, new Node(lable));

	}

	public void addEdge(String from, String to, int weight) {
		Node fromNode = nodes.get(from);
		if (fromNode == null)
			throw new IllegalArgumentException();
		Node toNode = nodes.get(to);
		if (toNode == null)
			throw new IllegalArgumentException();
		fromNode.addEdge(toNode, weight);
		toNode.addEdge(fromNode, weight);
	}

	public void print() {
		for (var node : nodes.values()) {
			var edges = node.getEdges();
			if (!edges.isEmpty())
				System.out.println(node + "is connected to" + edges);

		}
	}

	private class NodeEntry {
		private Node node;
		private int priority;

		public NodeEntry(Node node, int priority) {

			this.node = node;
			this.priority = priority;
		}
	}

	public Path getShortestPath(String from, String to) {
		Map<Node, Integer> distance = new HashMap<>();
		var fromNode = nodes.get(from);
		var toNode = nodes.get(to);
		for (var node : nodes.values()) {
			distance.put(node, Integer.MAX_VALUE);
			distance.replace(fromNode, 0);

		}
		Map<Node, Node> previousNode = new HashMap<>();
		Set<Node> visited = new HashSet<>();
		PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.priority));
		queue.add(new NodeEntry(fromNode, 0));
		while (!queue.isEmpty()) {
			var current = queue.remove().node;
			visited.add(current);

			for (var edge : current.getEdges()) {
				if (visited.contains(edge.to))
					continue;
				var newDistance = distance.get(current) + edge.Weight;
				if (newDistance < distance.get(edge.to)) {
					distance.replace(edge.to, newDistance);
					previousNode.put(edge.to, current);
					queue.add(new NodeEntry(edge.to, newDistance));
				}
			}

		}

		return buildPath(previousNode, toNode);
	}

	private Path buildPath(Map<Node, Node> previousNode, Node toNode) {
		Stack<Node> stack = new Stack<>();
		stack.push(toNode);
		var previous = previousNode.get(toNode);
		while (previous != null) {
			stack.push(previous);
			previous = previousNode.get(previous);
		}

		var path = new Path();
		while (!stack.isEmpty()) {
			path.add(stack.pop().lable);
		}
		return path;
	}

	
}
