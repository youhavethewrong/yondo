/* Represents a roll of the dice.
 * Die roll specification inspired by rolldice's spec => 
 *          {#x}{#}d[#|%]{*#}{+/-#}{s#}
 */

package info.youhavethewrong.yondo

import org.apache.commons.lang3.StringUtils;


class DiceRoll {
	private def dieSpecPattern = ~/((?:\d+x)?)((?:\d+)?)d(\d+|%)((?:\*\d+)?)((?:s\d+)?)/
	private def randGen = new Random()

	private def parse(dieSpec) {
		def matchmaker = dieSpecPattern.matcher(dieSpec)
		return matchmaker.findAll()
	}

	private def getRandom(die) {
		return randGen.nextInt(Integer.valueOf(die))+1
	}

	public def roll(dieSpec) {
		def sum = 0
		def parts = parse(dieSpec)

		def setCount = parts[0][1]
		def dieCount = parts[0][2]
		def faces = parts[0][3]
		def multiplier = parts[0][4]
		def drop = parts[0][5]

		//println "${setCount}x${dieCount}d${faces}*${multiplier}s${drop}"

		if(!StringUtils.isBlank(faces)) {
			if(faces.equals("%")) {
				faces = "100"
			}
		}

		if(!StringUtils.isBlank(dieCount)) {
			dieCount = Integer.valueOf(dieCount)
			for(def i=0; i < dieCount; i++) {
				sum += getRandom(faces)
			}
		}
		else {
			sum = getRandom(faces)
		}
		return sum
	}
}
