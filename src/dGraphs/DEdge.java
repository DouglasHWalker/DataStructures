package dGraphs;

public class DEdge {
	private int source;
	private int dest;
	private double weight;
	
	public DEdge(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}


	public DEdge(int source, int dest, double weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}


	/**
	 * @return the source
	 */
	public int getSource() {
		return source;
	}


	/**
	 * @param source the source to set
	 */
	public void setSource(int source) {
		this.source = source;
	}


	/**
	 * @return the dest
	 */
	public int getDest() {
		return dest;
	}


	/**
	 * @param dest the dest to set
	 */
	public void setDest(int dest) {
		this.dest = dest;
	}


	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}


	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dest;
		result = prime * result + source;
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DEdge other = (DEdge) obj;
		if (dest != other.dest)
			return false;
		if (source != other.source)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DEdge [source=" + source + ", dest=" + dest + ", weight=" + weight + "]";
	}
}
