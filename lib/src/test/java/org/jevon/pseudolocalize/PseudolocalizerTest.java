/**
 * 
 */
package org.jevon.pseudolocalize;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Jevon
 *
 */
class PseudolocalizerTest {

	@Test
	void testHello() {
		assertEquals("ħḗŀŀǿ", Pseudolocalizer.addAccents("hello"));
		assertEquals("heelloo", Pseudolocalizer.lengthen("hello"));
		assertEquals("[hello]", Pseudolocalizer.addBrackets("hello"));
		assertEquals("[ħḗḗŀŀǿǿ]", Pseudolocalizer.pseudolocalize("hello"));
	}

	@Test
	void testMyString() {
		assertEquals("[ḿẏ īīƞƥŭŭŧ şŧřīīƞɠ]", Pseudolocalizer.pseudolocalize("my input string"));
	}

}
