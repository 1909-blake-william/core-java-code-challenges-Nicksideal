package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

		/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String acronym = "";

		acronym = acronym.concat(phrase.substring(0, 1));

		phrase = phrase.replace("-", " ");

		for (int i = 1; i <= phrase.length() - 1; i++) {
			if (phrase.substring(i, i + 1).equals(" ")) {
				acronym = acronym.concat(phrase.substring(i + 1, i + 2).toUpperCase());
			}
		}

		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (this.sideOne == this.sideTwo) {
				if (this.sideOne == this.sideThree) {
					if (this.sideTwo == this.sideThree) {
						System.out.println("Triangle is equilateral");
					}
				}

			} else {
				return false;
			}
			// TODO Write an implementation for this method declaration
			return true;
		}

		public boolean isIsosceles() {
			if (sideOne == sideTwo) {
				if (sideTwo == sideThree) {
					if (sideThree == sideOne) {
						System.out.println("This is not an isosceles");
					}
				} else {
					System.out.println("This is an isosceles");
				}
			} else if (sideThree == sideOne) {
				System.out.println(("This is an isosceles"));

			} else if (sideTwo == sideThree) {
				if (sideThree == sideTwo) {
					System.out.println("This is an isosceles");
				}
			} else {
				return false;
			}

			// TODO Write an implementation for this method declaration
			return true;
		}

		public boolean isScalene() {
			if (sideOne != sideTwo) {
				if (sideOne != sideThree) {
					if (sideTwo != sideThree) {
						System.out.println("Triangle is scalene");
					}
				}

			} else {
				return false;
			}
			// TODO Write an implementation for this method declaration
			return true;
		}
	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		string = string.toLowerCase();

		int[] points = new int[string.length()];

		int[] scrNum = new int[string.length()];
		String[] stringArr = string.split("");
		for (int s = 0; s < stringArr.length; s++) {
			switch (stringArr[s]) {
			case "a":
			case "e":
			case "i":
			case "o":
			case "u":
			case "l":
			case "n":
			case "r":
			case "s":
			case "t":
				points[s] = 1;
				break;
			case "d":
			case "g":
				points[s] = 2;
				break;
			case "b":
			case "m":
			case "p":
			case "c":
				points[s] = 3;
				break;
			case "f":
			case "h":
			case "v":
			case "w":
			case "y":
				points[s] = 4;
				break;
			case "k":
				points[s] = 5;
				break;
			case "j":
			case "x":
				points[s] = 8;
				break;
			case "q":
			case "z":
				points[s] = 10;
				break;
			}
		}

		int totalScore = IntStream.of(points).sum();

		return totalScore;

		// enhanced for with a switch statement
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		string = string.replace("-", "");
		string = string.replace("(", "");
		string = string.replace(")", "");
		string = string.replace(" ", "");
		string = string.replace(".", "");

		if (string.length() > 10) {
			throw new IllegalArgumentException();
		} else if (string.contains("^[0-9]")) {
			throw new IllegalArgumentException();
		} else {

		}

		return string;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		string = string.replace(",", " ");
		string = string.replace("\n", "");
		String[] sent = string.split(" ");

		int count = 1;
		int repeat = 1;
		Map<String, Integer> wordMap = new HashMap<String, Integer>();

		for (String s : sent) {
			if (wordMap.containsKey(s)) {
				wordMap.get(s);
				repeat++;
				wordMap.put(s, repeat);
			} else {
				wordMap.put(s, count);
			}
		}
		return wordMap;
	}

//map.get(s)
	// int = map.get(s+1)
	// .map.put(s,count
	/**
	 * 7. Implement a binary search algorithm.//comparator is what we want. List
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

//compareTo method
		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration

			// comp.compare(o1,o2);
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration

		String[] word = string.split(" ");
		String[] pLatin = new String[word.length];
		boolean cons = true;
		for (int i = 0; i < word.length; i++) {
			if (word[i].charAt(0) == 'a' || word[i].charAt(0) == 'e' || word[i].charAt(0) == 'i'
					|| word[i].charAt(0) == 'o' || word[i].charAt(0) == 'u') {
				for (i = 0; i < word.length; i++) {
					pLatin[i] = (word[i] + "ay");
				}
			} else {

				for (int j = 0; j < word[i].length(); j++)
					if (word[i].charAt(j) != 'a' && word[i].charAt(j) != 'e' && word[i].charAt(j) != 'i'
							&& word[i].charAt(j) != 'o' && word[i].charAt(j) != 'u') {
						if (word[i].charAt(j) == 'q') {
							String consToRemove = word[i].substring(0, (j + 2));
							String wordToRebuild = word[i].substring((j + 2), word[i].length());
							
							for (int k = 0; k < 1; k++) {
								pLatin[i] = (wordToRebuild + consToRemove + "ay");
								cons = false;
							}
							if (!cons) {
								break;
							}
						}
					} else {
						String consToRemove = word[i].substring(0, j);
						String wordToRebuild = word[i].substring(j, word[i].length());
						for (int k = 0; k < j; k++) {
							pLatin[i] = (wordToRebuild + consToRemove + "ay");
							cons = false;
						}
						if (!cons) {
							break;
						}
					}

			}
		}

		String transP = Arrays.toString(pLatin);
		transP = transP.replace("[", "");
		transP = transP.replace("]", "");
		transP = transP.replace(",", "");
		return transP;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		boolean arm = true;
		double[] num, prod;
		int i, j;
		num = new double[Integer.toString(input).length()];
		String arrBuild = Integer.toString(input);

		for (j = 0; j < arrBuild.length(); j++) {
			num[j] = Integer.parseInt(arrBuild.substring(j, j + 1));
		}

		prod = new double[num.length];
		for (i = 0; i < Integer.toString(input).length(); i++) {
			prod[i] = Math.pow(num[i], arrBuild.length());
		}

		double sumOfArr = 0;
		for (i = 0; i < prod.length; i++) {
			sumOfArr += prod[i];
		}
		int compare = (int) sumOfArr;
		if (compare == input) {
			arm = true;
		} else {
			arm = false;
		}
		return arm;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> primeFac = new ArrayList<Long>();
		long input = l;
		for (int i = 2; i <= input; i++) {
			if (input % i == 0) {
				primeFac.add((long) i);
				input /= i;
				i--;
			}
		}
		return primeFac;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {// find the ascii from the character and change it to the cipher.
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration

			String coded = "";
			int ASCII = 0;
			for (int i = 0; i < string.length(); i++) {
				if (Character.isLetter(string.charAt(i))) {
					ASCII = (int) string.charAt(i);

					if (65 < ASCII && ASCII < 90) {// Check if ASCII range is for Upper Case
						ASCII += this.key;
						if (ASCII > 90) {
							ASCII = 64 + (ASCII - 90);
							coded += (char) ASCII;

						} else if (ASCII < 65) {
							ASCII = 91 - (65 - ASCII);
							coded += (char) ASCII;

						} else {
							coded += (char) ASCII;

						}

					} else {
						ASCII += this.key;// here is the ASCII range for lower case
						if (ASCII > 122) {
							ASCII = 96 + (ASCII - 122);
							coded += (char) ASCII;
						} else if (ASCII < 97) {
							ASCII = 123 - (97 - ASCII);
							coded += (char) ASCII;

						} else {
							coded += (char) ASCII;
						}

					}
				} else {
					coded += string.charAt(i);
				}

			}
			return coded;
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		int count = 3;
		int primeNum = 0;
		int notPrime = 0;
		if (i < 1) {
			throw new IllegalArgumentException();
		}
		if (1 == i) {
			primeNum = 2;
			return primeNum;
		}
		if (2 == i) {
			primeNum = 3;
			return primeNum;
		}
		if (3 == i) {
			primeNum = 5;
			return primeNum;
		}
		for (int t = 2; t < 200000; t++) {

			if (t % 2 == 0) {
				notPrime++;// Was not a prime
			} else if (t % 3 == 0) {
				notPrime++;// almost a prime!
			} else if (t % 5 == 0) {
				notPrime++;// NOPE! Definitely not a prime
			} else {

			}
			if (notPrime > 0) {
				notPrime = 0;
			} else {
				count++;
			}
			if (count == i) {
				primeNum = t;
				break;
			}
		} // fix array and match values to follow prime
//count to keep track how many prime numbers were found
		// save the prime number
		return primeNum;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			String[] alphabet = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
					"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
			String[] cypher = new String[alphabet.length];
			List<Integer> cypherOrd = new ArrayList<Integer>();
			for (int i1 = alphabet.length - 1, j1 = 0; i1 >= 0; i1--, j1++) {
				cypher[j1] = alphabet[i1];
			}
			//obtain the list of positions
			for (int word=0; word<string.length();word++) {
				for(int alph = 0; word<alphabet.length; word++) {
//					if (string.charAt(word) == alphabet[charAt.(alph)] {
//						cypherOrd.add(alph);
//					}
				}
			}
			//build the encoded sentence.
			String [] encoded = new String[cypherOrd.size()];
			for(int position =0; position < cypherOrd.size();position++) {
				encoded[position]=cypher[cypherOrd.get(position)];
			}
			//String encWord = encoded[].tostring;
			return null;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1)*Switch* mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
		string = string.replace(" ", "");
		string = string.replace("-", "");
		String [] strArr= string.split("");
		int[] toSum = new int[string.length()];
		for (int i=0; i<string.length();i++) {
			if (Character.isLetter(string.charAt(i))&& string.charAt(i)!='X') {
				return false;
			}
			switch(i) {
			case 0:
				toSum[i]+=Integer.parseInt(strArr[i])*10;
				break;
			case 1:
				toSum[i]+=Integer.parseInt(strArr[i])*9;
				break;
			case 2:
				toSum[i]+=Integer.parseInt(strArr[i])*8;
				break;
			case 3:
				toSum[i]+=Integer.parseInt(strArr[i])*7;
				break;
			case 4:
				toSum[i]+=Integer.parseInt(strArr[i])*6;
				break;
			case 5:
				toSum[i]+=Integer.parseInt(strArr[i])*5;
				break;
			case 6:
				toSum[i]+=Integer.parseInt(strArr[i])*4;
				break;
			case 7:
				toSum[i]+=Integer.parseInt(strArr[i])*3;
				break;
			case 8:
				toSum[i]+=Integer.parseInt(strArr[i])*2;
				break;
			case 9:
				if(string.charAt(i)=='X') {
				toSum[i]+=10;
				}else {
					toSum[i]+=Integer.parseInt(strArr[i])*1;
				}
				break;
				
			}
			
		}
		int sum = IntStream.of(toSum).sum();
		if(sum%11==0) {
			return true;
		}else {
			return false;
		}
		
		
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		char[] lowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		string = string.replace(" ", "");
		char[] test = string.toCharArray();
		int i, j, count = 0;
		boolean pangram = false;
		for (i = 0; i < lowerCase.length; i++) {
			for (j = 0; j < test.length; j++) {
				if (lowerCase[i] == test[j]) {
					count++;
					break;
				}
			}
		}
		if (count == 26) {
			pangram = true;
		}

		return pangram;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// LocalDateTime object - temporal objects
		// TODO Write an implementation for this method declaration
		if (given instanceof LocalDate) {
			LocalDate notToday = (LocalDate) given;
			LocalDateTime today = LocalDateTime.of(notToday, LocalTime.of(0, 0, 0));
			today = today.plusSeconds(1000000000);
			return today;
		} else {
			LocalDateTime today = (LocalDateTime) given;
			today = today.plusSeconds(1000000000);
			return today;
		}

	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		// find
		List<Integer> sumList = new ArrayList<Integer>();

		int k, p;
		for (k = 0; k < set.length; k++) {
			for (p = i - 1; p > 0; p--) {
				if (p % set[k] == 0) {
					sumList.add(p);
				} else {

				}
			}
		}

		for (k = 0; k < sumList.size(); k++) {
			for (p = k + 1; p < sumList.size(); p++) {
				if (sumList.get(k) == (sumList.get(p))) {
					sumList.remove(p);
				}
			}
		} // Consider using a hashmap instead of a list
		int[] sumArr = sumList.stream().mapToInt(Integer::intValue).toArray();

		int sum = IntStream.of(sumArr).sum();
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a
	 * number greater than 9 then subtract 9 from the product. The results of our
	 * doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		boolean valid = false;
		int i;
		string = string.replace(" ", "");
		String[] arrStr = string.split("");
		int[] work = new int[arrStr.length];

		if (string.contains("-") || string.contains("a")) {
			valid = false;
		} else {
			// populating my integer array
			for (i = 0; i < arrStr.length; i++) {
				work[i] = Integer.parseInt(arrStr[i]);
			}
			// doubling the second digits, starting from the first digit and updating the
			// arr.
			for (i = arrStr.length - 2; i > 0; i = i - 2) {
				work[i] = work[i] * 2;
				if (work[i] > 9) {
					work[i] = work[i] - 9;

				} else {

				}
			}
			// now we sum the contents of the doubled array and validate.
			int sum = IntStream.of(work).sum();
			if (sum % 10 == 0) {
				valid = true;
			} else {
				valid = false;
			}
		}
		return valid;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		// switch statement.
		int answer = 0;
		string = string.replace("?", "");
		String[] splitStr = string.split(" ");
		List<String> clean = new ArrayList<String>();
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < splitStr.length; i++) {
			clean.add(splitStr[i]);
		}

		for (int c = 0; c < clean.size(); c++) {
			if (clean.get(c).matches("-?\\d+")) {
				for (int t = 0; t < 1; t++) {
					nums.add(Integer.parseInt(clean.get(c)));
				}
			}
		}

		for (String s : clean) {
			switch (s) {
			case "plus":
				answer = nums.get(0) + nums.get(1);
				break;
			case "minus":
				answer = nums.get(0) - nums.get(1);
				break;
			case "multiplied":
				answer = nums.get(0) * nums.get(1);
				break;
			case "divided":
				answer = nums.get(0) / nums.get(1);
				break;

			}
		}

		return answer;
	}

}
