/**
 * 
 */
package org.jevon.pseudolocalize;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Simple psuedolocalisation methods.
 * Based on https://github.com/tryggvigy/pseudo-localization/ (MIT license)
 * 
 * @author Jevon
 *
 */
@NonNullByDefault
public class Pseudolocalizer {
	
	public static final Map<Character,Character> LATIN_ACCENT_MAP = createLatinAccentMap();
	
	private static Map<Character,Character> createLatinAccentMap() {
		Map<Character,Character> result = new HashMap<>();

		result.put('a', 'ȧ');
		result.put('A', 'Ȧ');
		result.put('b', 'ƀ');
		result.put('B', 'Ɓ');
		result.put('c', 'ƈ');
		result.put('C', 'Ƈ');
		result.put('d', 'ḓ');
		result.put('D', 'Ḓ');
		result.put('e', 'ḗ');
		result.put('E', 'Ḗ');
		result.put('f', 'ƒ');
		result.put('F', 'Ƒ');
		result.put('g', 'ɠ');
		result.put('G', 'Ɠ');
		result.put('h', 'ħ');
		result.put('H', 'Ħ');
		result.put('i', 'ī');
		result.put('I', 'Ī');
		result.put('j', 'ĵ');
		result.put('J', 'Ĵ');
		result.put('k', 'ķ');
		result.put('K', 'Ķ');
		result.put('l', 'ŀ');
		result.put('L', 'Ŀ');
		result.put('m', 'ḿ');
		result.put('M', 'Ḿ');
		result.put('n', 'ƞ');
		result.put('N', 'Ƞ');
		result.put('o', 'ǿ');
		result.put('O', 'Ǿ');
		result.put('p', 'ƥ');
		result.put('P', 'Ƥ');
		result.put('q', 'ɋ');
		result.put('Q', 'Ɋ');
		result.put('r', 'ř');
		result.put('R', 'Ř');
		result.put('s', 'ş');
		result.put('S', 'Ş');
		result.put('t', 'ŧ');
		result.put('T', 'Ŧ');
		result.put('v', 'ṽ');
		result.put('V', 'Ṽ');
		result.put('u', 'ŭ');
		result.put('U', 'Ŭ');
		result.put('w', 'ẇ');
		result.put('W', 'Ẇ');
		result.put('x', 'ẋ');
		result.put('X', 'Ẋ');
		result.put('y', 'ẏ');
		result.put('Y', 'Ẏ');
		result.put('z', 'ẑ');
		result.put('Z', 'Ẑ');			
		
		return result;
	}
	
	/**
	 * Turns "hello" into "ħḗŀŀǿ"
	 */
	public static String addAccents(String s) {
		return addAccents(s, LATIN_ACCENT_MAP);
	}
	
	/**
	 * Turns "hello" into "ħḗŀŀǿ" or similar, using the given map of characters.
	 */
	public static String addAccents(String s, Map<Character,Character> replacementMap) {
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			Character key = Character.valueOf(array[i]);
			if (replacementMap.containsKey(key)) {
				array[i] = replacementMap.get(key);
			}
		}
		
		return new String(array);
	}
	
	/**
	 * Turns "hello" into "[hello]"
	 */
	public static String addBrackets(String s) {
		return "[" + s + "]";
	}
	
	/**
	 * Turns "hello" into "heelloo"
	 */
	public static String lengthen(String s) {
		// "duplicate "a", "e", "o" and "u" to emulate ~30% longer text"
		@Nullable String result = s.replace("a", "aa").replace("e", "ee").replace("i", "ii").replace("o", "oo").replace("u", "uu");
		if (result == null) {
			// String.replace() doesn't have "@NonNull" annotation
			throw new NullPointerException("unexpected null from replace");
		}
		return result;
	}
	
	/**
	 * Emulates https://github.com/tryggvigy/pseudo-localization/
	 * and turns "hello" into "[ħḗḗŀŀǿǿ]".
	 */
	public static String pseudolocalize(String s) {
		return addBrackets(addAccents(lengthen(s)));
	}
	
}
