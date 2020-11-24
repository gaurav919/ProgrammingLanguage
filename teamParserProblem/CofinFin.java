import java.util.*;

public class CofinFin {

/// THIS IS THE TEMPLATE YOU SHOULD USE FOR THE TEAM PROJECT
	/*
	 * 
	 * 
	 * Team members: 
	 * Nick Doane
	 * Gaurav Aryal
	 * 
	 * 
	 * 
	 * Replace the stub code for each of the constructors and methods given below
	 * with correct code.
	 * 
	 * 
	 */
	private static final long RAND_SEED = 0L;

	private static final Random rng = new Random(RAND_SEED);

	private static final int Max = Integer.MAX_VALUE, MaxDiv2 = Max / 2;

	private static CofinFin emT;

	private boolean isComplemented;
	private TreeSet<Integer> theSet; // should never be null, even if
	// the set is empty

	/*
	 * 
	 * This class implements an instance of a subset of the natural numbers, { 0, 1,
	 * 2, ... }, that is either finite or cofinite(that is, its complement with
	 * respect to the natural numbers is theSet) according to the following scheme.
	 * 
	 * There are two mutually exclusive cases
	 * 
	 * Case I: the represented set is finite
	 * 
	 * isComplemented is false
	 * 
	 * theSet has exactly the members of the set which are ordered ascending in the
	 * tree.
	 * 
	 * Examples
	 * 
	 * 1. empty set isComplemented is false theSet is empty, BUT NOT NULL
	 * 
	 * 2. { 0, 2, 4 } isComplemented is false theSet has the values { 0, 2, 4 }
	 * 
	 * 
	 * Case II: the represented is cofinite
	 * 
	 * isComplemented is true and theSet has all the values that are NOT in the
	 * represented value.
	 * 
	 * Below we use N to stand for the set of natural numbers { 0, 1, 2, 3, ... }
	 * 
	 * Examples
	 * 
	 * 1. N = ( 0, 1, 2, 3, ... } isComplemented is true theSet is empty, BUT NOT
	 * NULL
	 * 
	 * 2. { 1, 3, 5, 6, 7, ... } isComplemented is true theSet has the values { 0,
	 * 2, 4 }
	 * 
	 * class invariant: theSet is not null and never contains a value < 0
	 * 
	 * Constructors should establish the class invariant and mutators should
	 * preserve it.
	 * 
	 */

	// constructors

	// I WILL CODE THIS ONE SO I CAN USE IT BELOW
	public CofinFin() {
		// constructs the rep of the empty set;
		// isComplemented is initialized to false by default
		theSet = new TreeSet<Integer>();

	}

	public CofinFin(boolean comp, int n) {
		/*
		 * 
		 * if n >= 0 if comp is false constructs the rep of { n } else constructs the
		 * rep of the complement of { n }
		 * 
		 * if n < 0 if comp is false creates the rep of the empty set else creates the
		 * rep of N
		 * 
		 * basically, ignore n if it's not >= 0
		 * 
		 * YOU NEED TO CODE THIS
		 * 
		 */
		this.theSet = new TreeSet<Integer>();
		if (n >= 0) {
			if (comp == false) {
				this.theSet.add(n);
			} else {
				this.theSet.add(n);
				this.isComplemented = true;
			}
		} else {
			if (comp == true) {
				this.isComplemented = true;
			}
		}
	}

	public CofinFin(boolean comp, int[] A) {
		/*
		 * if comp is false if A is null constructs the rep of the empty set else
		 * constructs the rep of the distinct values in A that are >= 0 (could be none,
		 * e.g., if A is { -1,-2,-3 }) else if A is null constructs the rep of all of
		 * the natural numbers else constructs the rep of the complement of all of the
		 * natural numbers (which are all >= 0) that are elements of A
		 * 
		 * YOU NEED TO CODE THIS
		 */
		this.theSet = new TreeSet<Integer>();
		if (comp == false) {
			if (A != null) {
				for (int i = 0; i < A.length; i++) {
					if (A[i] >= 0) {
						this.theSet.add(A[i]);
					}
				}
			}
		} else {
			this.isComplemented = true;
			if (A != null) {
				int cur;
				for (int i = 0; i < A.length; i++) {
					cur = A[i];
					if (cur >= 0) {
						this.theSet.add(cur);
					}
				}
			}
		}
	}

	// mutators

	public void remove(int n) {
		/*
		 * if n < 0 or n is not in the set represented by this, no changes are made
		 * else, the rep is modified to reflect the removal of n from the set this
		 * represents /* YOU NEED TO CODE THIS
		 */
		if (n < 0) { 						//make sure the number isn't < 0
			return;
		}else if (!this.isComplemented) {	//if it isn't complemented, we remove it
			this.theSet.remove(n);			//remove() searches and removes it if it exists, otherwise does nothing
		}else {								//else is if it is complemented
			this.theSet.add(n);				//add() adds it if it isn't there, otherwise does nothing
		}
		

	}

	public void add(int n) {
		/*
		 * 
		 * if n < 0 or n is in the set represented by this, no changes are made else,
		 * the rep is modified to reflect the addition of n to the set this represents
		 * 
		 * YOU NEED TO CODE THIS
		 */
		
		if (n < 0) {						//this is basically just the remove method but backwards
			return;							//because it's the same stuff happening just in reverse
		}else if (!this.isComplemented) {
			this.theSet.add(n);
		}else {
			this.theSet.remove(n);
		}
	}

	// operations

	public CofinFin union(CofinFin other) throws Exception {

		/*
		 * 
		 * Error checking:
		 * 
		 * 1. checks that other is not null; if it is, it throws an exception with the
		 * message
		 * 
		 * "Invalid call to union: other is null"
		 * 
		 * 
		 * otherwise it creates and returns a new value that represents the union of
		 * this and other;
		 * 
		 * this and other are NOT modified and there are no shared data members between
		 * the new object and the operands. Note, it is possible that this == other, as
		 * in
		 * 
		 * CofinFin A,C;
		 * 
		 * A = new CofinFin(); C = A.union(A);
		 * 
		 * 
		 * YOU NEED TO CODE THIS
		 * 
		 */
		if (other == null) {
			throw new Exception("Invalid call to union: other is null");
		}
		CofinFin union = new CofinFin();
		if (this.isComplemented == false && other.isComplemented == false) { // let A = {1,2,3} B = {1,3,4} U =
																				// {1,2,3,4}

			union.theSet.addAll(this.theSet); // So if both set are not complemented then we just add all the element of
												// both set to get the union.
			union.theSet.addAll(other.theSet);
		} else if (this.isComplemented == true && other.isComplemented == false) { // this = cmp{1,2,4} other={2,5,8} ,
																					// Union = comp {1,4}
			union.isComplemented = true; // this = {3,5,6,7,8,...N} other = {2,5,8} , Union = {2,3,5,6,7,8....N} so
											// basically comp{1,4}
			union.theSet.addAll(this.theSet);
			union.theSet.removeAll(other.theSet);
		} else if (this.isComplemented == false && other.isComplemented == true) { // similarly, this = {2,8,9} , other
																					// = cmp{2,8,10} , U = cmp{10}
			union.isComplemented = true;
			union.theSet.addAll(other.theSet);
			union.theSet.removeAll(this.theSet);
		} else if (this.isComplemented == true && other.isComplemented == true) { // this = cmp{2,8,9} , other =
																					// cmp{1,5,7,9} , U = cmp{9}

			union.isComplemented = true; // So looking at the example I came up with comp(A) U comp(B) = comp(AnB)
			Iterator<Integer> itr = this.theSet.iterator();
			while (itr.hasNext()) {
				int num = itr.next();
				if (other.theSet.contains(num)) {
					union.theSet.add(num);
				}
			}

		}
		return union;
	}

	public CofinFin intersect(CofinFin other) throws Exception {
		/*
		 * 
		 * Error checking:
		 * 
		 * 1. checks that other is not null; if it is, it throws an exception with the
		 * message
		 * 
		 * "Invalid call to intersect: other is null"
		 * 
		 * 
		 * otherwise it creates and returns a new value that represents the intersection
		 * of this and other;
		 * 
		 * this and other are NOT modified and there are no shared data members between
		 * the new object and the operands. Note, it is possible that this == other, as
		 * in
		 * 
		 * CofinFin A,C;
		 * 
		 * A = new CofinFin(); C = A.intersect(A);
		 * 
		 * 
		 * YOU NEED TO CODE THIS
		 * 
		 */
		if (other == null) {
			throw new Exception("Invalid call to union: other is null");
		}
		CofinFin inter = new CofinFin();
		if (this.isComplemented == false && other.isComplemented == false) { // A = 1,3,6,7} B = { 2,3,4,6,5,7} n =
																				// {3,6,7}
			inter.theSet.addAll(this.theSet); // ={1,3,6,7}
			inter.theSet.retainAll(other.theSet); // = {1,3,6,7} n { 2,3,4,6,5,7} = {3,6,7}

			return inter;
		}

		else if (this.isComplemented == true && other.isComplemented == false) {
			if (this.theSet.containsAll(other.theSet)) {
				return inter;
				// This if condition is used to return empty set . for example A= cmp{1,2,3,4}
				// B={1,2,3,4} n= {}
				// Basically , A = {5,6,7,..N} B= {1,2,3,4} so n={}.
			} else {
				// A = cmp{1,5,6,8} B={1,5,7,8,9,10,11} n= {7,9}
				// Basically, A = {2,3,4,7,9,10,..N} B={1,5,7,8,9,10,11} n = {7,9}
				Iterator<Integer> itr = other.theSet.iterator(); //
				while (itr.hasNext()) {
					int num = itr.next();
					if (!this.theSet.contains(num)) {
						inter.theSet.add(num);
					}

				}
				return inter;
			}
		}

		else if (this.isComplemented == false && other.isComplemented == true) {
			if (other.theSet.containsAll(this.theSet)) {
				// Same reason as above
				return inter;
			} else {
				// same reason as above just the cmp set and finite set are changed
				Iterator<Integer> itr = this.theSet.iterator();
				while (itr.hasNext()) {
					int num = itr.next();
					if (!other.theSet.contains(num)) {
						inter.theSet.add(num);
					}

				}
				return inter;
			}
		}

		else { // when both set are complimented
				// A = comp{1,2,4,6,7} B = comp{2.4.3.5}
				// Basically, A = {3,5,8....N} B = {1,6.7...N} n = { 8,9,10....N} so basically
				// cmp{1,2,3,4,5,6,7}
			inter.isComplemented = true;
			inter.theSet.addAll(this.theSet);
			inter.theSet.addAll(other.theSet);
			return inter;
		}

	}

	public CofinFin complement() {
		/*
		 * 
		 * 
		 * creates and returns a new value that represents the complement of this; this
		 * is NOT modified;
		 * 
		 * 
		 * YOU NEED TO CODE THIS
		 * 
		 * 
		 */

		CofinFin cmp = new CofinFin();
		cmp.theSet.addAll(this.theSet);
		cmp.isComplemented = !this.isComplemented;
		return cmp;
	}

	public boolean isIn(int n) {
		/*
		 * 
		 * 
		 * returns false if n < 0 or n is not in the set represented by this else
		 * returns true
		 * 
		 * this is not modified;
		 * 
		 * 
		 * YOU NEED TO CODE THIS
		 * 
		 */

		// for the compiler
		if (n < 0) {
			return false;
		}else {
			boolean results = this.theSet.contains(n);
			if (this.isComplemented == true) {
				results = !results;
			}
			return results;
		}

	}

	public String toString() {
		/*
		 * If isComplemented is false if the set is empty returns the string "{}" else
		 * returns the string "{ v1, v2, ... , vk }" where the vi are the distinct k
		 * values in the set sorted in increasing order For example, { 0, 2, 3 } should
		 * return the string "{ 0, 2, 3 }" else returns the string CMPx where x is the
		 * string for the set if isComplemented were false, for example, all the natural
		 * numbers would have the string "CMP{}", the set that is all natural numbers
		 * except { 1, 3, 5 }, would have the string "CMP{ 1, 3, 5 }", etc.
		 * 
		 */

		boolean notEmpt = !theSet.isEmpty();

		StringBuffer bf = new StringBuffer();

		if (isComplemented)
			bf.append("CMP");

		bf.append('{');
		if (notEmpt) {
			bf.append(' ');

			Iterator<Integer> iter = theSet.iterator();

			while (iter.hasNext()) {
				bf.append(iter.next().toString());
				if (iter.hasNext())
					bf.append(", ");
			}
			bf.append(' ');
		}

		bf.append('}');

		return bf.toString();
	}

	public boolean equals(CofinFin other) throws Exception {
		/*
		 * 
		 * Error checking:
		 * 
		 * 1. checks that other is not null; if it is, it throws an exception with the
		 * message
		 * 
		 * "Invalid call to equals: other is null"
		 * 
		 * 
		 * otherwise it returns true when the isComplemented data members are the same
		 * and the theSet data members are equal as sets, else false
		 * 
		 * creates and returns a new value that represents the intersection of this and
		 * other;
		 * 
		 * Hint: use the equals method for TreeSet.
		 * 
		 * YOU NEED TO CODE THIS
		 * 
		 */
		if (other == null) {
			throw new Exception ("Invalid call to equals: other is null");
		}
		
		boolean isEqual = false;
		if (this.isComplemented && other.isComplemented) {
			if(this.theSet.equals(other.theSet)) {
				isEqual = true;
			}
		}else if (!this.isComplemented && !other.isComplemented) {
			if(this.theSet.equals(other.theSet)) {
				isEqual = true;
			}
		}

		return isEqual;
	}

	public boolean isSubsetOf(CofinFin other) throws Exception {
		/*
		 * 
		 * Error checking:
		 * 
		 * 1. checks that other is not null; if it is, it throws an exception with the
		 * message
		 * 
		 * "Invalid call to isSubsetOf: other is null"
		 * 
		 * 
		 * otherwise it returns true when the set represented by this is a subset of the
		 * set represented by other, and false if it is not a subset of the set represented by
		 * other.
		 * 
		 * YOU NEED TO CODE THIS
		 * 
		 * 
		 * Hint: do a case by case analysis
		 * 
		 * this other what do you need to test
		 * 
		 * finite finite finite cofinite cofinite finite cofinite cofinite
		 * 
		 */
		if (other == null) {
			throw new Exception ("Invalid call to isSubsetOf: other is null");
		}
		
		boolean isSubset;
		if(this.isComplemented && other.isComplemented) {
			isSubset = other.theSet.containsAll(this.theSet);
		}else if(other.isComplemented) {
			isSubset = !other.theSet.containsAll(this.theSet);
		}else if(this.isComplemented) {
			isSubset = false;
		}else {
			isSubset = other.theSet.containsAll(this.theSet);
		}
		return isSubset;
	}

	public int maximum() throws Exception {
		/*
		 * 
		 * if this is cofinite throws an exception with the message
		 * "Invalid call to maximum: receiver is cofinite" else if this is finite and
		 * empty throws an exception with the message
		 * "Invalid call to maximum: receiver is empty" else // this is finite and not
		 * empty returns the maximum value in this
		 * 
		 * YOU NEED TO CODE THIS
		 * 
		 */
		if (isComplemented) {
			throw new Exception("Invalid call to maximum: receiver is cofinite");
		} else if (theSet.isEmpty()) {
			throw new Exception("Invalid call to maximum: receiver is empty");
		}
		return this.theSet.last();

	}

	public int minimum() throws Exception {
		/*
		 * YOU NEED TO CODE THIS
		 */
		/*
		 * 
		 * if this represents the empty set throws an exception with the message
		 * "Invalid call to minimum: receiver is empty" else // this is not empty
		 * returns the minimum value in the set represented by this
		 * 
		 */
		if (theSet.isEmpty()) {
			throw new Exception("Invalid call to minimum: receiver is empty");
		}
		return this.theSet.first();
	}

	private static // so they will all be initialized to null
	CofinFin
	// I don't use l for an identifier
	a, b, c, d, e, f, g, h, i, j, k, m, n, o, p, q, r, s, t, u, v, w, x, y, z,

			aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az,

			ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn, bo, bp, bq, br, bs, bt, bu, bv, bw, bx, by, bz,

			cc, dd, ee,

			newA, newB, newC; // 25 + 52 + 6 = 83 variables

//  the driver tests the methods
	public static void main(String[] args) throws Exception {

		boolean res;

		int ii, jj, kk;

		int[][] arrayConstants = { { -1, -2, -3, -4 }, { 0, 1, 2, 3 }, { -1, 0, -2, 1, -3, 2, -4 }, { 2, 3, 5, 7 },
				{ 1, 3, 5, 7 }, { 1, 2, 3, 4 }, { 0, 1, 5, 6, 7, 10, 11, 13 }, { 2, 3, 6, 8, 9 },
				{ 2, 4, 6, 8, 10, 13 }, { 13, 15, 17, 19, 21 }, { 3, 5, 7, 11 }, { 1, 2, 3, 7 }, { 10, 30, 50, 70 },
				{ 10, 20, 30, 70 }, { 0, 1, 4, 5, 6, 7, 9 }, { 0, 1, 4, 5, 6, 7, 9, 10 }, { 8, 9, 11, 12 },
				{ 0, 1, 4, 5, 6, 7, 8, 10, 11, 12 }, { 100, 200, 300, 400, 500, 1000 }, { 0, 2, 4, 6, 8, 10, 12, 14 },
				{ 1, 3, 5, 7, 9, 11, 13, 15, 17 }, new int[0], null, { -1 }, { 0 }, { 100 }, {} };

		CofinFin[] fromStaticVariables = {

				a, b, c, d, e, f, g, h, i, j, k, m, n, o, p, q, r, s, t, u, v, w, x, y, z,

				aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az,

				ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn, bo, bp, bq, br, bs, bt, bu, bv, bw, bx, by, bz,

				cc, dd, ee,

				newA, newB, newC },
				// 25 + 52 + 6 = 83 variables

				allTestCases = new CofinFin[arrayConstants.length * 2 + fromStaticVariables.length];

		//////////////// SIMPLE CONSTRUCTOR TESTS

		System.out.println("Simple Constructor Tests.\n");

		a = new CofinFin(false, -1);
		System.out.println("a = " + a);
		b = new CofinFin(true, -2);
		System.out.println("b = " + b);
		c = new CofinFin(false, 1000);
		System.out.println("c = " + c);
		d = new CofinFin(true, 1234);
		System.out.println("d = " + d);
		e = new CofinFin(false, 0);
		System.out.println("e = " + e);
		f = new CofinFin(true, 0);
		System.out.println("f = " + f);
		g = new CofinFin(false, 1);
		System.out.println("g = " + g);
		h = new CofinFin(true, 1);
		System.out.println("h = " + h);
		i = new CofinFin(false, Integer.MAX_VALUE);
		System.out.println("i = " + i);

		//////////////// ARRAY CONSTRUCTOR TESTS

		System.out.println("\nArray Constructor Tests\n");

		for (int i = 0; i < arrayConstants.length * 2; i++) {
			if (i < arrayConstants.length)
				allTestCases[i] = new CofinFin(false, arrayConstants[i]);
			else
				allTestCases[i] = new CofinFin(true, arrayConstants[i - arrayConstants.length]);
			System.out.println("i = " + i + " CofinFin is " + allTestCases[i]);
		}

		//////////////// ISIN REMOVE AND ADD TESTS

		System.out.println("\nisIn and remove and add Tests\n");

		for (int i = 0; i < arrayConstants.length * 2; i++) {
			CofinFin temp = allTestCases[i];
			boolean isIn0 = temp.isIn(0), isIn1 = temp.isIn(1), isInMaxDiv2 = temp.isIn(MaxDiv2),
					isInMax = temp.isIn(Max);

			System.out.println("The four isIn results are " + isIn0 + " " + isIn1 + " " + isInMaxDiv2 + " " + isInMax);

			temp.remove(-1);
			temp.remove(0);
			temp.remove(1);
			temp.remove(MaxDiv2);
			temp.remove(Max);
			System.out.println("i = " + i + " after the four removes, temp is " + temp);

			// restore prior value
			if (isIn0)
				temp.add(0);
			if (isIn1)
				temp.add(1);
			if (isInMaxDiv2)
				temp.add(MaxDiv2);
			if (isInMax)
				temp.add(Max);

			System.out.println("After restoration, value is " + temp);
		}

		//////////////// MORE ADD TESTS

		// construct a few explicitly
		j = new CofinFin();
		j.isComplemented = false;
		j.theSet.add(1000);

		k = new CofinFin();
		k.isComplemented = true;
		k.theSet.add(1000);

		m = new CofinFin();
		m.isComplemented = true;
		m.theSet.add(500);

		j.add(-1);
		k.add(-2);
		m.add(Integer.MIN_VALUE);

		System.out.println("j = " + j.toString());
		System.out.println("k = " + k.toString());
		System.out.println("m = " + m.toString());

		System.out.println("\nAdd Tests\n");

		j = new CofinFin(true, new int[] { 1, 2, 3 });
		j.add(-1);
		j.add(Integer.MIN_VALUE);
		System.out.println("After adding -1 and " + Integer.MIN_VALUE + " to j, j = " + j.toString());

		for (ii = arrayConstants.length * 2; ii < allTestCases.length; ii++) {
			if (allTestCases[ii] == null) { // create a new instance
				int size = rng.nextInt(10);
				allTestCases[ii] = new CofinFin(rng.nextBoolean(), null);
				for (int v = 0; v < size; v++)
					allTestCases[ii].add(rng.nextInt(Max));
			}
			// make a copy of the current value
			CofinFin tc = new CofinFin();
			tc.isComplemented = allTestCases[ii].isComplemented;
			tc.theSet.addAll(allTestCases[ii].theSet);

			System.out.println("Testing add for " + tc.toString());
			tc.add(-2);
			System.out.println("After adding -2, new value is " + tc.toString());
			tc.add(Integer.MIN_VALUE);
			System.out.println("After adding " + Integer.MIN_VALUE + ", new value is " + tc.toString());

			for (jj = 0; jj < 100;) {
				tc.add(jj);
				System.out.println("After adding " + jj + ", new value is " + tc.toString());
				jj = 2 * jj + 1;
			}

		}

		//////////////// UNION TESTS

		System.out.println("\nUnion Tests\n");

		for (int i = 0; i < allTestCases.length; i++) {
			CofinFin outer = allTestCases[i];
			for (int j = 0; j < allTestCases.length; j++)
				System.out.println(" (i,j) = (" + i + ", " + j + ") result = " + outer.union(allTestCases[j]));
		}

		// test exception
		try {
			CofinFin xxx = allTestCases[0].union(null);
			System.out.println("result is " + xxx);
		} catch (Exception e) {
			System.out.println("Union with null other threw an exception with message '" + e.getMessage() + "'");
		}

		//////////////////// INTERSECTION TESTS

		System.out.println("\nIntersection Tests\n");

		for (int i = 0; i < allTestCases.length; i++) {
			CofinFin outer = allTestCases[i];
			for (int j = 0; j < allTestCases.length; j++)
				System.out.println(" (i,j) = (" + i + ", " + j + ") result = " + outer.intersect(allTestCases[j]));
		}

		// test exception
		try {
			CofinFin xxx = allTestCases[0].intersect(null);
			System.out.println("result is " + xxx);
		} catch (Exception e) {
			System.out.println("Intersection with null other threw an exception with message '" + e.getMessage() + "'");
		}

		//////////////////// COMPLEMENT TESTS

		System.out.println("\nComplement Tests\n");

		for (int i = 0; i < allTestCases.length; i++)
			System.out.println("i = " + i + " result = " + allTestCases[i].complement());

		// test that complement does not share the Set data member
		j = new CofinFin(false, new int[] { 1, 2, 3 });
		m = j.complement();
		m.add(1);
		m.remove(4);
		System.out.println("after adding 1 to m and removing 4, j is " + j);
		j = new CofinFin(true, new int[] { 1, 2, 3 });
		m = j.complement();
		m.remove(1);
		m.add(4);
		System.out.println("after adding 4 to m and removing 1, j is " + j);

		///////////////// IS IN TESTS

		System.out.println("\nisIn Tests\n");

		for (int i = 0; i < allTestCases.length; i++) {
			CofinFin outer = allTestCases[i];
			for (int j = 0; j < 50; j++)
				System.out.println(" (i,j) = (" + i + ", " + j + ") isIn result = " + outer.isIn(j));
		}

		///////////////// SUBSET TESTS

		System.out.println("\nSubset Tests\n");

		for (int i = 0; i < allTestCases.length; i++) {
			CofinFin outer = allTestCases[i];
			for (int j = 0; j < allTestCases.length; j++)
				System.out.println(
						" (i,j) = (" + i + ", " + j + ") subset result = " + outer.isSubsetOf(allTestCases[j]));
		}

		// test exception
		emT = new CofinFin(false, null);
		try {

			System.out.println("Result for empty set is subset of null = " + emT.isSubsetOf(null));

		} catch (Exception ee) {
			System.out.println(
					"Call to isSubsetOf with null other threw an exception with message '" + ee.getMessage() + "'");
		}

		///////////////// EQUALS TESTS

		System.out.println("\nEquals Tests\n");

		for (int i = 0; i < allTestCases.length; i++) {
			CofinFin outer = allTestCases[i];
			for (int j = 0; j < allTestCases.length; j++)
				System.out.println(" (i,j) = (" + i + ", " + j + ") equals result = " + outer.equals(allTestCases[j]));
		}

		// test exception
		try {

			System.out.println("empty set equals null is " + emT.equals(null));

		} catch (Exception e) {
			System.out
					.println("Call to equals with null other threw an exception with message '" + e.getMessage() + "'");
		}

		/////////////// MINIMUM TESTS

		System.out.println("\nMinimum Tests\n");

		for (ii = 0; ii < allTestCases.length; ii++) {
			System.out.println("Minimum test # " + ii);
			try {
				System.out.println("Min value is " + allTestCases[ii].minimum());
			} catch (Exception e) {
				System.out.println("The call threw an exception with message '" + e.getMessage() + "'");
			}
		}

		/////////////// MAXMIMUM TESTS

		System.out.println("\nMaximmum Tests\n");

		for (ii = 0; ii < allTestCases.length; ii++) {
			System.out.println("Maximum test # " + ii);
			try {
				System.out.println("Max value is " + allTestCases[ii].maximum());
			} catch (Exception e) {
				System.out.println("The call threw an exception with message '" + e.getMessage() + "'");
			}
		}

		////////////// TESTS FOR SIDE EFFECTS OF THE OPERATIONS

		System.out.println("\nSide Effect Tests.\n");

		CofinFin x1 = new CofinFin(), x2 = new CofinFin();

		x1.theSet.add(Integer.MAX_VALUE - 1);
		x2.theSet.add(Integer.MAX_VALUE - 2);
		x2.isComplemented = true;

		for (ii = 0; ii < allTestCases.length; ii++) {
			allTestCases[ii].union(x2);
			x2.union(allTestCases[ii]);
			allTestCases[ii].intersect(x1);
			x1.intersect(allTestCases[ii]);
			allTestCases[ii].complement();
			System.out.println("ii = " + ii + " " + allTestCases[ii]);
		}

	}
}
