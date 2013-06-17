/* Represents a roll of the dice.
 * Die roll specification inspired by rolldice's spec => 
 *          {#x}{#}d[#|%]{*#}{+/-#}{s#}
 */

package info.youhavethewrong.yondo

import org.apache.commons.lang3.StringUtils;


class DiceRoll {
	private def dieSpecPattern = ~/(?:(\d+)x)?((?:\d+)?)d(\d+|%)(?:\*(\d+))?(?:(\+|-)(\d+))?(?:s(\d+))?/
	private def randGen = new Random()

	public List<Integer> roll(dieSpec) {
		def sums = []

		def parts = parse(dieSpec)

		def setCount = cleanUpSets(parts[0][1])
		def dieCount = cleanUpDice(parts[0][2])
		def faces = checkForPercent(parts[0][3])
		def multiplier = cleanUpMultiplier(parts[0][4])
		def modifier = cleanUpModifier(parts[0][5])
		def modifierAmount = cleanUpModifierAmount(parts[0][6])
		def drop = cleanUpDrop(parts[0][7])

		setCount = Integer.valueOf(setCount)
		dieCount = Integer.valueOf(dieCount)
		faces = Integer.valueOf(faces)
		multiplier = Integer.valueOf(multiplier)
		modifierAmount = Integer.valueOf(modifierAmount)
		drop = Integer.valueOf(drop)

		for(def h=0; h < setCount; h++) {
			def rolls = rollDice(dieCount, faces)

			if(drop > 0) {
				rolls = rolls.sort();
				if(drop < rolls.size()) {
					for(def i=0; i < drop; i++) {
						rolls.remove(0)
					}
				}
			}

			if(multiplier != 1) {
				rolls = rolls.collect { it *= multiplier }
			}

			if(modifierAmount != 0) {
				if(modifier.equals("+")) {
					rolls = rolls.collect { it += modifierAmount }
				}
				else if(modifier.equals("-")) {
					rolls = rolls.collect { it -= modifierAmount }
				}
			}

			def sum = 0
			rolls.each { sum += it }
			sums[h] = sum
		}

		return sums
	}

	private def parse(dieSpec) {
		def matchmaker = dieSpecPattern.matcher(dieSpec)
		return matchmaker.findAll()
	}

	private def getRandom(die) {
		return randGen.nextInt(die)+1
	}

	private List rollDice(dieCount, faces) {
		def rolls = []
		for(def i=0; i < dieCount; i++) {
			rolls[i] = getRandom(faces)
		}
		return rolls
	}

	private def cleanUpSets(sets) {
		if(StringUtils.isBlank(sets)) {
			sets = "1"
		}
		return sets
	}

	private def cleanUpDice(dice) {
		if(StringUtils.isBlank(dice)) {
			dice = "1"
		}
		return dice
	}

	private def checkForPercent(faces) {
		if(!StringUtils.isBlank(faces)) {
			if(faces.equals("%")) {
				faces = "100"
			}
		}
		return faces
	}

	private def cleanUpDrop(drop) {
		if(StringUtils.isBlank(drop)) {
			drop = "0"
		}
		return drop
	}

	private def cleanUpMultiplier(multiplier) {
		if(StringUtils.isBlank(multiplier)) {
			multiplier = "1"
		}
		return multiplier
	}

	private def cleanUpModifier(modifier) {
		if(StringUtils.isBlank(modifier)) {
			modifier = "+"
		}
		return modifier
	}

	private def cleanUpModifierAmount(amount) {
		if(StringUtils.isBlank(amount)) {
			amount = "0"
		}
		return amount
	}
}
