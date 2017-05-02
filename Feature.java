package model;

import java.io.Serializable;

public class Feature implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// fields
	private String name, description;
	private boolean custom; // is this even necessary?
	
	// default constructor
	public Feature() {
		name = "";
		description = "";
		custom = false;
	}
	
	// already existing feature
	public Feature (String s) {
		name = s;
		if (!match()) {
			//System.out.println("Oh no");
		}
		custom = false;
	}
	
	// for features with multiple versions
	/**public Feature(String s, int i) {
		name = s;
		switch (name) {
		case "Draconic Ancestry":
			ancestry(i);
			break;
		case "Rage":
			rage(i);
			break;
		case "Brutal Critical":
			brutalCritical(i);
			break;
		case "Bardic Inspiration":
			bardicInspiration(i);
			break;
		case "Song of Rest":
			songOfRest(i);
			break;
		default:
			break;
		}
		custom = false;
	}*/
	
	
	// custom feature
	public Feature(String name, String description) {
		this.name = name;
		this.description = description;
		custom = true;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			String s = (String)obj;
			if (s.equals(this.name)) return true;
			else return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	// getters
	public String getName() { return name; }
	public String getDescription() { return description; }
	public boolean isCustom() { return custom; }
	
	
	// feature data
	private boolean match() {
		boolean found = true;
		
		switch (name) {
		// background features
		case "Shelter of the Faithful": // acolyte
			description = "As an acolyte, you command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. "
					+ "You and your adventuring companions can expect to receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needer for spells. "
					+ "Those who share your religion will support you (but only you) at a modest lifestyle.\n"
					+ "You might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have a residence there. "
					+ "This could be the temple where you used to serve, if you remain on good terms with it, or a temple where you have found a new home. "
					+ "While near your temple, you can call upon the priests for assistance, provided the assisstance you ask for is not hazardous and you remain in good standing with your temple.";
			break;
		case "False Identity": // charlatan
			description = "You have created a second identity that includes documentation, established acquaintances, and disguises that allow you to assume that persona. "
					+ "Additionally, you can forge documents including official papers and personal letters, as long as you have seen an example of the kind of document or the handwriting you are trying to copy.";
			break;
		case "Criminal Contact": // criminal
			description = "You have a reliable and trustworthy contact who acts as your liason to a network of other criminals. "
					+ "You know how to get messages to and from your contact, even over great distances: specifically you know the local messengers, "
					+ "corrupt caravan masters, and seedy sailors who can deliver messages for you.";
			break;
		case "By Popular Demand": // bard
			description = "You can always find a place to perform, usually in an inn or tavern but possibly with a circus, at a theator, or even in a noble's court. "
					+ "At such a place, you receive free lodging and food of a modest or comfortable standard (depending on the quality of the establishment), as long as you perform each night. "
					+ "In addition, your performance makes you something of a local figure. "
					+ "When strangers recognize you in a town where you have performed, they typically take a liking to you.";
			break;
		case "Rustic Hospitality": // folk hero
			description = "Since you come from the ranks of the common folk, you fit in among them with ease. "
					+ "You can find a place to hide, rest, or recuperate among other commoners, unless you have shown yourself to be a danger to them. "
					+ "They will shield you from the law or anyone else searching for you, though they will not risk their lives for you.";
			break;
		case "Guild Membership": // guild artisan
			description = "As an established and respected member of a guild, you can rely on certain benefits that membership provides. "
					+ "Your fellow guild members will provide you with loding and food if necessary, and pay for your funeral if needed. "
					+ "In some cities and towns, a guildhall offers a central place to meet other members of your profession, which can be a good place to meet potential patrons, allies, or hirelings.\n"
					+ "Guilds often wield tremendous political power. "
					+ "If you are accused of a crime, your guild will support you if a good case can be made for your innocence or the crime is justifiable. "
					+ "You can also gain access to powerful political figures through the guild, if you are a member in good standing. "
					+ "Such connections might require the donation of money or magic items to the guild's coffers.\n"
					+ "You must pay dues of 5 gp per month to the guild. "
					+ "If you miss payments, you must make up back dues to remain in the guild's good graces.";
			break;
		case "Discovery": // hermit
			description = "The quiet seclusion of your extended hermitage gave you access to a unique and pow erful discovery. "
					+ "The exact nature of this revelation depends on the nature of your seclusion. "
					+ "It might be a great truth about the cosmos, the deities, the pow erful beings of the outer planes, or the forces of nature. "
					+ "It could be a site that no one else has ever seen. "
					+ "You might have uncovered a fact that has long been forgotten, or unearthed some relic of the past that could rewrite history. ";
			break;
		case "Position of Privilege": // noble
			description = "Thanks to your noble birth, people are inclined to think the best of you. "
					+ "You are welcome in high society, and people assume you have the right to be wherever you are. "
					+ "The common folk make every effort to accommodate you and avoid your displeasure, "
					+ "and other people of high birth treat you as a member of the same social sphere. "
					+ "You can secure an audience with a local noble if you need to.";
			break;
		case "Wanderer": // outlander
			description = "You have an excellent memory for maps and geography, and you can always recall the general layout of terrain, "
					+ "settlements, and other features around you. In addition, you can find food and fresh water for yourself and up to five other people "
					+ "each day, provided that the land offers berries, small game, water, and so forth.";
			break;
		case "Researcher": // sage
			description = "When you attempt to learn or recall a piece of lore, if you do not know that information, "
					+ "you often know where and from whom you can obtain it. Usually, this information comes from a library, scriptorium, university, "
					+ "or a sage or other learned person or creature. Your DM might rule that the knowledge you seek is secreted away in an almost "
					+ "inaccessible place, or that it simply cannot be found. Unearthing the deepest secrets of the multiverse can require an "
					+ "adventure or even a whole campaign.";
			break;
		case "Ship's Passage": // sailor
			description = "When you need to, you can secure free passage on a sailing ship for yourself and your adventuring companions. "
					+ "You might sail on the ship you served on, or another ship you have good relations with (perhaps one captained by a former crewmate). "
					+ "Because you’re calling in a favor, you can’t be certain of a schedule or route that will meet your every need. "
					+ "Your Dungeon Master will determine how long it takes to get where you need to go. In return for your free passage, you and your "
					+ "companions are expected to assist the crew during the voyage.";
			break;
		case "Bad Reputation": // sailor variant
			description = "No matter where you go, people are afraid of you due to your reputation. When you are in a civilized settlement, "
					+ "you can get away with minor criminal offenses, such as refusing to pay for food at a tavern or breaking down doors at a local shop, "
					+ "since most people will not report your activity to the authorities.";
			break;
		case "Military Rank": // soldier
			description = "You have a military rank from your career as a soldier. Soldiers loyal to your former military organization still recognize "
					+ "your authority and influence, and they defer to you if they are of a lower rank. You can invoke your rank to exert influence over "
					+ "other soldiers and requisition simple equipment or horses for temporary use. You can also usually gain access to friendly military "
					+ "encampments and fortresses where your rank is recognized.";
			break;
		case "City Secrets": // urchin
			description = "You know the secret patterns and flow to cities and can find passages through the urban sprawl that others would miss. "
					+ "When you are not in combat, you (and companions you lead) can travel between any two locations in the city twice as fast "
					+ "as your speed would normally allow.";
			break;
			// generic racial features
		case "Darkvision":
			description = "Accustomed to life underground, you have superior vision in dark and dim conditions. You "
					+ "can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You "
					+ "can’t discern color in darkness, only shades of gray.";
			break;
			// dwarven features
		case "Dwarven Resilience":
			description = "You have advantage on saving throws against poison, and you have resistance against poison damage (explained in chapter 9)";
			break;
		case "Stonecunning":
			description = "Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient in the History skill and add "
					+ "double your proficiency bonus to the check, instead of your normal proficiency bonus.";
			break;
			// hill dwarf feature
		case "Dwarven Toughness":
			description = "Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.";
			break;
			// elf/half-elf feature
		case "Fey Ancestry":
			description = "You have advantage on saving throws against being charmed, and magic can’t put you to sleep.";
			break;
			// wood elf feature
		case "Mask of the Wild":
			description = "You can attempt to hide even when you are only lightly obscured by foliage, heavy rain, falling snow, mist, and other natural phenomena.";
			break;
			// dark elf (drow) features
		case "Superior Darkvision":
			description = "Your darkvision has a radius of 120 feet.";
			break;
		case "Sunlight Sensitivity":
			description = "You have disadvantage on attack rolls and on Wisdom (Perception) checks that rely on sight when you, the target of your attack, or whatever "
					+ "you are trying to perceive is in direct sunlight.";
			break;
			// halfling features
		case "Lucky":
			description = "When you roll a 1 on an attack roll, ability check, or saving throw, you can reroll the die and must use the new roll.";
			break;
		case "Brave":
			description = "You have advantage on saving throws against being frightened.";
			break;
		case "Halfling Nimbleness":
			description = "You can move through the space of any creature that is of a size larger than yours.";
			break;
			// lightfoot feature
		case "Naturally Stealthy":
			description = "You can attempt to hide even when you are obscured only by a creature that is at least one size larger than you.";
			break;
			// stout feature
		case "Stout Resilience":
			description = "You have advantage on saving throws against poison, and you have resistance against poison damage.";
			break;
			// dragonborn features
		case "Draconic Ancestry":
			description = "";
			break;
		case "Breath Weapon":
			description = "You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation.\n"
					+ "When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, "
					+ "the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + "
					+ "your Constitution m odifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half "
					+ "as much damage on a successful one. The damage increases to 3d6 at 6th level, 4d6 at 11th level, and 5d6 at 16th level.\n"
					+ "After you use your breath weapon, you can’t use it again until you complete a short or long rest.";
			break;
		case "Damage Resistance":
			description = "You have resistance to the damage type associated with your draconic ancestry.";
			break;
			// gnome feature
		case "Gnome Cunning":
			description = "You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.";
			break;
			// forest gnome feature
		case "Speak with Small Beasts":
			description = "Through sounds and gestures, you can communicate simple ideas with Small or smaller beasts. Forest gnomes love animals and often "
					+ "keep squirrels, badgers, rabbits, moles, woodpeckers, and other creatures as beloved pets.";
			break;
			// rock gnome features
		case "Artificer's Lore":
			description = "Whenever you make an Intelligence (History) check related to magic items, alchemical objects, or technological devices, you can add twice your "
					+ "proficiency bonus, instead of any proficiency bonus you normally apply.";
			break;
		case "Tinker":
			description = "You have proficiency with artisan’s tools (tinker’s tools). Using those tools, you can spend 1 "
					+ "hour and 10 gp worth of materials to construct a Tiny clockwork device (AC 5, 1 hp). The device ceases "
					+ "to function after 24 hours (unless you spend 1 hour repairing it to keep the device functioning), or when "
					+ "you use your action to dismantle it; at that time, you can reclaim the materials used to create it. You can have up "
					+ "to three such devices active at a time.\n"
					+ "When you create a device, choose one of the following options:\n"
					+ "Clockwork Toy: This toy is a clockwork animal, monster, or person, such as a frog, mouse, bird, dragon, or "
					+ "soldier. When placed on the ground, the toy moves 5 feet across the ground on each of your turns in a random direction. It makes noises as appropriate "
					+ "to the creature it represents.\n"
					+ "Fire Starter: The device produces a miniature flame, which you can use to light a candle, torch, or campfire. Using the device requires your action.\n"
					+ "Music Box: When opened, this music box plays a single song at a moderate volume. The box stops playing when it reaches the song’s end or when it is closed.";
			break;
			// half-orc features
		case "Relentless Endurance":
			description = "When you are reduced to 0 hit points but not killed outright, you can drop to 1 hit point instead. You can’t use this feature again until you "
					+ "finish a long rest.";
			break;
		case "Savage Attacks":
			description = "When you score a critical hit with a melee weapon attack, you can roll one of the weapon’s damage dice one additional time and add it to the extra "
					+ "damage of the critical hit.";
			break;
			// tiefling feature
		case "Hellish Resistance":
			description = "You have resistance to fire damage.";
			break;
			// barbarian features
		case "Rage":
			description = "";
			break;
		case "Brutal Critical":
			description = "";
			break;
		case "Reckless Attack":
			description = "You can throw aside all concern for defense to attack with fierce desperation. When you make your first attack on your turn, you can decide "
					+ "to attack recklessly. Doing so gives you advantage on melee weapon attack rolls using Strength during this "
					+ "turn, but attack rolls against you have advantage until your next turn.";
			break;
		case "Danger Sense":
			description = "You gain an uncanny sense of when things nearby aren’t as they should be, giving you an edge when you dodge away from danger.\n"
					+ "You have advantage on Dexterity saving throws against effects that you can see, such as traps and spells. "
					+ "To gain this benefit, you can’t be blinded, deafened, or incapacitated.";
			break;
			// Extra Attack is not limited to the barbarian class
		case "Extra Attack":
			description = "You can attack twice, instead of once, whenever you take the Attack action on your turn.";
			break;
		case "Fast Movement":
			description = "Your speed increases by 10 feet while you aren’t wearing heavy armor.";
			break;
		case "Feral Instinct":
			description = "Your instincts are so honed that you have advantage on initiative rolls.\n"
					+ "Additionally, if you are surprised at the beginning of combat and aren’t incapacitated, you can act normally "
					+ "on your first turn, but only if you enter your rage before doing anything else on that turn.";
			break;
		case "Relentless Rage":
			description = "Your rage can keep you fighting despite grievous wounds. If you drop to 0 hit points while you’re raging and don’t die outright, you can make "
					+ "a DC 10 Constitution saving throw. If you succeed, you drop to 1 hit point instead.\n"
					+ "Each time you use this feature after the first, the DC increases by 5. When you finish a short or long rest, the DC resets to 10";
			break;
		case "Persistent Rage":
			description = "Your rage is so fierce that it ends early only if you fall unconscious or if you choose to end it.";
			break;
		case "Indomitable Might":
			description = "If your total for a Strength check is less than your Strength score, you can use that score in place of the total.";
			break;
		case "Primal Champion":
			description = "You embody the power of the wilds. Your Strength and Constitution scores increase by 4. Your maximum for those scores is now 24.";
			break;
			// path of the berserker
		case "Frenzy":
			description = "You can go into a frenzy when you rage. If you do so, for the duration of your rage you can make a single melee "
					+ "weapon attack as a bonus action on each of your turns after this one. When your rage ends, you suffer one level of exhaustion.";
			break;
		case "Mindless Rage":
			description = "You can’t be charmed or frightened while raging. If you are charmed or frightened when you enter your rage, the effect is "
					+ "suspended for the duration of the rage.";
			break;
		case "Intimidating Presence":
			description = "You can use your action to frighten someone with your menacing presence. When you do so, choose one creature that you can see "
					+ "within 30 feet of you. If the creature can see or hear you, it must succeed on a Wisdom saving throw (DC "
					+ "equal to 8 + your proficiency bonus + your Charisma modifier) or be frightened of you until the end of your "
					+ "next turn. On subsequent turns, you can use your action to extend the duration of this effect on the frightened "
					+ "creature until the end of your next turn. This effect ends if the creature ends its turn out of line of sight or more than 60 feet away from you.\n"
					+ "If the creature succeeds on its saving throw, you can't use this feature on that creature again for 24 hours.";
			break;
		case "Retaliation":
			description = "When you take damage from a creature that is within 5 feet of you. you can use "
					+ "your reaction to make a melee weapon attack against that creature.";
			break;
			// path of the totem warrior
		case "Spirit Seeker":
			description = "You gain the ability to cast the beast sense and speak with animals spells, but only as rituals, as described in chapter 10.";
			break;
		case "Totem Spirit":
			description = "You choose a totem spirit and gain its feature. You must make or acquire a physical totem object - an amulet or similar "
					+ "adornment — that incorporates fur or feathers, claws, teeth, or bones of the totem animal. At your option, you "
					+ "also gain minor physical attributes that are reminiscent of your totem spirit. For example, if you have a bear "
					+ "totem spirit, you might be unusually hairy and thickskinned, or if your totem is the eagle, your eyes turn bright yellow.\n"
					+ "Your totem animal might be an animal related to those listed here but more appropriate to your homeland. "
					+ "For example, you could choose a hawk or vulture in place of an eagle.\n"
					+ "Bear: While raging, you have resistance to all damage except psychic damage. The spirit of the bear makes you "
					+ "tough enough to stand up to any punishment.\n"
					+ "Eagle: While you're raging and aren’t wearing heavy armor, other creatures have disadvantage on "
					+ "opportunity attack rolls against you, and you can use the Dash action as a bonus action on your turn. The spirit "
					+ "of the eagle makes you into a predator who can weave through the fray with ease.\n"
					+ "Wolf: While you're raging, your friends have advantage on melee attack rolls against any creature "
					+ "within 5 feet of you that is hostile to you. The spirit of the wolf makes you a leader of hunters.";
			break;
		case "Aspect of the Beast":
			description = "You gain a magical benefit based on the totem animal of your choice. You can choose the same animal you selected at 3rd level or a different one.\n"
					+ "Bear: You gain the might of a bear. Your carrying capacity (including maximum load and maximum lift) "
					+ "is doubled, and you have advantage on Strength checks made to push, pull, lift, or break objects.\n"
					+ "Eagle: You gain the eyesight of an eagle. You can see up to 1 mile away with no difficulty, able to discern "
					+ "even fine details as though looking at something no more than 100 feet away from you. Additionally, dim "
					+ "light doesn't impose disadvantage on your Wisdom (Perception) checks.\n"
					+ "Wolf: You gain the hunting sensibilities of a wolf. You can track other creatures while traveling at a fast pace, "
					+ "and you can move stealthily while traveling at a normal pace.";
			break;
		case "Spirit Walker":
			description = "You can cast the commune with nature spell, but only as a ritual. When you do so, a spiritual "
					+ "version of one of the animals you chose for Totem Spirit or Aspect of the Beast appears to you to convey the information you seek.";
			break;
		case "Totemic Attunement":
			description = "You gain a magical benefit based on a totem animal of your choice. You can choose the same animal you selected previously or a different one.\n"
					+ "Bear: While you’re raging, any creature within 5 feet of you that’s hostile to you has disadvantage on attack "
					+ "rolls against targets other than you or another character with this feature. An enemy is immune to this effect if it "
					+ "can’t see or hear you or if it can’t be frightened.\n"
					+ "Eagle: While raging, you have a flying speed equal to your current walking speed. This benefit works only in "
					+ "short bursts; you fall if you end your turn in the air and nothing else is holding you aloft.\n"
					+ "Wolf: While you’re raging, you can use a bonus action on your turn to knock a Large or sm aller creature prone "
					+ "when you hit it with melee weapon attack.";
			break;
			// bard features
		case "Bardic Inspiration":
			description = "";
			break;
		case "Song of Rest":
			description = "";
			break;
		case "Jack of All Trades":
			description = "You can add half your proficiency bonus, rounded down, to any ability check you make that doesn’t already include your proficiency bonus.";
			break;
		case "Expertise":
			description = "Choose two of your skill proficiencies. Your proficiency bonus is doubled for any ability check you "
					+ "make that uses either of the chosen proficiencies. At 10th level, you can choose another two skill proficiencies to gain this benefit.";
			break;
		case "Font of Inspiration":
			description = "You regain all of your expended uses of Bardic Inspiration when you finish a short or long rest.";
			break;
		case "Countercharm":
			description = "You gain the ability to use musical notes or words of power to disrupt mind-influencing effects. As "
					+ "an action, you can start a performance that lasts until the end of your next turn. During that time, you and any "
					+ "friendly creatures within 30 feet of you have advantage on saving throws against being frightened or charmed. "
					+ "A creature must be able to hear you to gain this benefit. The performance ends early if you are incapacitated or "
					+ "silenced or if you voluntarily end it (no action required).";
			break;
		case "Superior Inspiration":
			description = "When you roll initiative and have no use sof Bardic Inspiration left, you regain one use.";
			break;
			// college of lore
		case "Cutting Words":
			description = "You learn how to use your wit to distract, confuse, and otherwise sap the confidence and competence of others. When a creature that you can "
					+ "see within 60 feet of you makes an attack roll, an ability check, or a damage roll, you can use your reaction to "
					+ "expend one of your uses of Bardic Inspiration, rolling a Bardic Inspiration die and subtracting the number "
					+ "rolled from the creature’s roll. You can choose to use this feature after the creature makes its roll, but before "
					+ "the DM determines whether the attack roll or ability check succeeds or fails, or before the creature deals its "
					+ "damage. The creature is immune if it can’t hear you or if it’s immune to being charmed.";
			break;
		case "Peerless Skill":
			description = "When you make an ability check, you can expend one use of Bardic Inspiration. Roll a Bardic Inspiration die and add the number rolled to "
					+ "your ability check. You can choose to do so after you roil the die for the ability check, but before the DM tells you whether you succeed or fail.";
			break;
			// college of valor
		case "Combat Inspiration":
			description = "You learn to inspire others in battle. A creature that has a Bardic Inspiration die from you "
					+ "can roll that die and add the number rolled to a weapon damage roll it just made. Alternatively, when an attack "
					+ "roll is made against the creature, it can use its reaction to roll the Bardic Inspiration die and add the number "
					+ "rolled to its AC against that attack, after seeing the roll but before knowing whether it hits or misses.";
			break;
		case "Battle Magic":
			description = "You have mastered the art of weaving spellcasting and weapon use into a single harmonious act. When you use your action to cast a bard spell, you "
					+ "can make one weapon attack as a bonus action.";
			break;
			// cleric features
		case "Channel Divinity":
			description = "At 2nd level, you gain the ability to channel divine energy directly from your deity, using that energy to fuel "
					+ "magical effects. You start with two such effects: Turn Undead and an effect determined by your domain. Some "
					+ "domains grant you additional effects as you advance in levels, as noted in the domain description.\n"
					+ "When you use your Channel Divinity, you choose "
					+ "which effect to create. You must then finish a short or "
					+ "long rest to use your Channel Divinity again.\n"
					+ "Some Channel Divinity effects require saving throws. "
					+ "When you use such an effect from this class, the DC "
					+ "equals your cleric spell save DC.\n"
					+ "Beginning at 6th level, you can use your Channel "
					+ "Divinity twice between rests, and beginning at 18th level, "
					+ "you can use it three times between rests. When you finish "
					+ "a short or long rest, you regain your expended uses.";
			break;
		case "Channel Divinity: Turn Undead":
			description = "As an action, you present your holy symbol and speak a "
					+ "prayer censuring the undead. Each undead that can see "
					+ "or hear you within 30 feet of you must make a Wisdom "
					+ "saving throw. If the creature fails its saving throw, it is "
					+ "turned for 1 minute or until it takes any damage.\n"
					+ "A turned creature must spend its turns trying to move "
					+ "as far away from you as it can, and it can’t willingly "
					+ "move to a space within 30 feet of you. It also can’t take "
					+ "reactions. For its action, it can use only the Dash action "
					+ "or try to escape from an effect that prevents it from "
					+ "moving. If there’s nowhere to move, the creature can use "
					+ "the Dodge action.";
			break;
		case "Destroy Undead":
			description = "Starting at 5th level, when an undead fails its saving "
					+ "throw against your Turn Undead feature, the creature is "
					+ "instantly destroyed if its challenge rating is at or below a "
					+ "certain threshold, as shown in the Destroy Undead table./n"
					+ "Cleric Level  Destroys Undead of CR . . ./n"
					+ "5th           1/2 or lower/n"
					+ "8th           1 or lower/n"
					+ "11th          2 or lower/n"
					+ "14th          3 or lower/n"
					+ "17th          4 or lower";
			break;
			// knowledge domain
		case "Blessings of Knowledge":
			description = "";
			break;
		case "Channel Divnity: Knowledge of the Ages":
			description = "";
			break;
		case "Channel Divnity: Read Thoughts":
			description = "";
			break;
		case "Potent Spellcasting": // multiple domains
			description = "";
			break;
		case "Visions of the Past":
			description = "";
			break;
			// life domain
		case "Disciple of Life":
			description = "";
			break;
		case "Channel Divinity: Preserve Life":
			description = "";
			break;
		case "Blessed Healer":
			description = "";
			break;
		case "Divine Strike": // multiple domains
			description = "";
			break;
		case "Supreme Healing":
			description = "";
			break;
			// light domain
		case "Warding Flare":
			description = "";
			break;
		case "Channel Divinity: Radiance of the Dawn":
			description = "";
			break;
		case "Improved Flare":
			description = "";
			break;
		case "Corona of Light":
			description = "";
			break;
			// nature domain
		case "Channel Divinity: Charm Animals and Plants":
			description = "";
			break;
		case "Dampen Elements":
			description = "";
			break;
		case "Master of Nature":
			description = "";
			break;
			// tempest domain
		case "Wrath of the Storm":
			description = "";
			break;
		case "Channel Divinity: Destructive Wrath":
			description = "";
			break;
		case "Thunderbolt Strike":
			description = "";
			break;
		case "Stormborn":
			description = "";
			break;
			// trickery domain
		case "Blessing of the Trickster":
			description = "";
			break;
		case "Channel Divinity: Inovke Duplicity":
			description = "";
			break;
		case "Channel Divinity: Cloak of Shadows":
			description = "";
			break;
		case "Improved Duplicity":
			description = "";
			break;
			// war domain
		case "War Priest":
			description = "";
			break;
		case "Channel Divinity: Guided Strike":
			description = "";
			break;
		case "Channel Divinity: War God's Blessing":
			description = "";
			break;
		case "Avatar of Battle":
			description = "";
			break;
			// druid features
		case "Wild Shape":
			description = "";
			break;
		case "Timeless Body":
			description = "";
			break;
		case "Beast Spells":
			description = "";
			break;
		case "Archdruid":
			description = "";
			break;
			// circle of the land
		case "Natural Recovery":
			description = "";
			break;
		case "Circle Spells":
			description = "";
			break;
		case "Land's Stride":
			description = "";
			break;
		case "Nature's Ward":
			description = "";
			break;
		case "Nature's Sanctuary":
			description = "";
			break;
			// circle of the moon
		case "Combat Wild Shape":
			description = "";
			break;
		case "Circle Forms":
			description = "";
			break;
		case "Primal Strike":
			description = "";
			break;
		case "Elemental Wild Shape":
			description = "";
			break;
		case "Thousand Forms":
			description = "";
			break;
			// fighter features
		case "Fighting Style (fighter)":
			description = "";
			break;
		case "Second Wind":
			description = "";
			break;
		case "Action Surge":
			description = "";
			break;
		case "Indomitable":
			description = "";
			break;
			// champion archetype
		case "Improved Critical":
			description = "";
			break;
		case "Remarkable Athlete":
			description = "";
			break;
		case "Additional Fighting Style":
			description = "";
			break;
		case "Superior Critical":
			description = "";
			break;
		case "Survivor":
			description = "";
			break;
			// battle master archetype
		case "Combat Superiority":
			description = "";
			break;
		case "Know Your Enemy":
			description = "";
			break;
		case "Improved Combat Superiority":
			description = "";
			break;
		case "Relentless":
			description = "";
			break;
			// eldritch knight archetype
		case "Weapon Bond":
			description = "";
			break;
		case "War Magic":
			description = "";
			break;
		case "Eldritch Strike":
			description = "";
			break;
		case "Arcane Charge":
			description = "";
			break;
		case "Improved War Magic":
			description = "";
			break;
			// monk features
		case "Unarmored Defense":
			description = "";
			break;
		case "Martial Arts":
			description = "";
			break;
		case "Ki":
			description = "";
			break;
		case "Unarmored Movement":
			description = "";
			break;
		case "Deflect Missiles":
			description = "";
			break;
		case "Slow Fall":
			description = "";
			break;
		case "Stunning Strike":
			description = "";
			break;
		case "Ki-Empowered Strikes":
			description = "";
			break;
		case "Evasion":
			description = "";
			break;
		case "Stillness of Mind":
			description = "";
			break;
		case "Purity of Body":
			description = "";
			break;
		case "Tongue of the Sun and Moon":
			description = "";
			break;
		case "Diamond Soul":
			description = "";
			break;
		case "Timeless Body (monk)":
			description = "";
			break;
		case "Empty Body":
			description = "";
			break;
		case "Perfect Self":
			description = "";
			break;
			// way of the open hand
		case "Open Hand Technique":
			description = "";
			break;
		case "Wholeness of Body":
			description = "";
			break;
		case "Tranquility":
			description = "";
			break;
		case "Quivering Palm":
			description = "";
			break;
			// way of shadow
		case "Shadow Arts":
			description = "";
			break;
		case "Shadow Step":
			description = "";
			break;
		case "Cloak of Shadows":
			description = "";
			break;
		case "Opportunist":
			description = "";
			break;
			// way of the four elements
		case "Disciple of the Elements":
			description = "";
			break;
			// paladin features
		case "Divine Sense":
			description = "";
			break;
		case "Lay on Hands":
			description = "";
			break;
		case "Fighting Style (paladin)":
			description = "";
			break;
		case "Divine Smite":
			description = "";
			break;
		case "Divine Health":
			description = "";
			break;
		case "Aura of Protection":
			description = "";
			break;
		case "Aura of Courage":
			description = "";
			break;
		case "Improved Divine Smite":
			description = "";
			break;
		case "Cleansing Touch":
			description = "";
			break;
			// oath of devotion
		case "Tenets of Devotion":
			description = "";
			break;
		case "Channel Divinity (devotion)":
			description = "";
			break;
		case "Aura of Devotion":
			description = "";
			break;
		case "Purity of Spirit":
			description = "";
			break;
		case "Holy Nimbus":
			description = "";
			break;
			// oath of the ancients
		case "Tenets of the Ancients":
			description = "";
			break;
		case "Channel Divinity (ancients)":
			description = "";
			break;
		case "Aura of Warding":
			description = "";
			break;
		case "Undying Sentinel":
			description = "";
			break;
		case "Elder Champion":
			description = "";
			break;
			// oath of vengeance
		case "Tenets of Vengeance":
			description = "";
			break;
		case "Channel Divinity (vengeance)":
			description = "";
			break;
		case "Relentless Avenger":
			description = "";
			break;
		case "Soul of Vengeance":
			description = "";
			break;
		case "Avenging Angel":
			description = "";
			break;
			// ranger features
		case "Favored Enemy":
			description = "";
			break;
		case "Natural Explorer":
			description = "";
			break;
		case "Fighting Style (ranger)":
			description = "";
			break;
		case "Primeval Awareness":
			description = "";
			break;
		case "Hide in Plain Sight":
			description = "";
			break;
		case "Vanish":
			description = "";
			break;
		case "Feral Senses":
			description = "";
			break;
		case "Foe Slayer":
			description = "";
			break;
			// hunter
		case "Hunter's Prey":
			description = "";
			break;
		case "Defensive Tactics":
			description = "";
			break;
		case "Multiattack":
			description = "";
			break;
		case "Superior Hunter's Defense":
			description = "";
			break;
			// beast master
		case "Ranger's Companion":
			description = "";
			break;
		case "Exceptional Training":
			description = "";
			break;
		case "Bestial Fury":
			description = "";
			break;
		case "Share Spells":
			description = "";
			break;
			// rogue features
		case "Expertise (rogue)":
			description = "";
			break;
		case "Sneak Attack":
			description = "";
			break;
		case "Thieves' Cant":
			description = "";
			break;
		case "Cunning Action":
			description = "";
			break;
		case "Uncanny Dodge":
			description = "";
			break;
		case "Reliable Talent":
			description = "";
			break;
		case "Blindsense":
			description = "";
			break;
		case "Slippery Mind":
			description = "";
			break;
		case "Elusive":
			description = "";
			break;
		case "Stroke of Luck":
			description = "";
			break;
			// thief
		case "Fast Hands":
			description = "";
			break;
		case "Second-Story Work":
			description = "";
			break;
		case "Supreme Sneak":
			description = "";
			break;
		case "Use Magic Device":
			description = "";
			break;
		case "Thief's Reflexes":
			description = "";
			break;
			// assassin
		case "Assassinate":
			description = "";
			break;
		case "Infiltration Expertise":
			description = "";
			break;
		case "Impostor":
			description = "";
			break;
		case "Death Strike":
			description = "";
			break;
			// arcane trickster
		case "Mage Hand Legerdemain":
			description = "";
			break;
		case "Magical Ambush":
			description = "";
			break;
		case "Versatile Trickster":
			description = "";
			break;
		case "Spell Thief":
			description = "";
			break;
			// sorcerer features
		case "Font of Magic":
			description = "";
			break;
		case "Metamagic":
			description = "";
			break;
		case "Sorcerous Restoration":
			description = "";
			break;
			// draconic bloodline
		case "Dragon Ancestor":
			description = "";
			break;
		case "Draconic Resilience":
			description = "";
			break;
		case "Elemental Affinity":
			description = "";
			break;
		case "Dragon Wings":
			description = "";
			break;
		case "Draconic Presence":
			description = "";
			break;
			// wild magic
		case "Wild Magic Surge":
			description = "";
			break;
		case "Tides of Chaos":
			description = "";
			break;
		case "Bend Luck":
			description = "";
			break;
		case "Controlled Chaos":
			description = "";
			break;
		case "Spell Bombardment":
			description = "";
			break;
			// warlock features
		case "Eldritch Invocations":
			description = "";
			break;
		case "Pact Boon":
			description = "";
			break;
		case "Mystic Arcanum":
			description = "";
			break;
		case "Eldritch Master":
			description = "";
			break;
			// the archfey
		case "Fey Presence":
			description = "";
			break;
		case "Misty Escape":
			description = "";
			break;
		case "Beguiling Defenses":
			description = "";
			break;
		case "Dark Delirium":
			description = "";
			break;
			// the fiend
		case "Dark One's Blessing":
			description = "";
			break;
		case "Dark One's Own Luck":
			description = "";
			break;
		case "Fiendish Resilience":
			description = "";
			break;
		case "Hurl Through Hell":
			description = "";
			break;
			// the great old one
		case "Awakened Mind":
			description = "";
			break;
		case "Entropic Ward":
			description = "";
			break;
		case "Thought Shield":
			description = "";
			break;
		case "Create Thrall":
			description = "";
			break;
			// wizard features
		case "Arcane Recovery":
			description = "";
			break;
		case "Arcane Tradition":
			description = "";
			break;
		case "Spell Mastery":
			description = "";
			break;
		case "Signature Spells":
			description = "";
			break;
			// school of abjuration
		case "Abjuration Savant":
			description = "";
			break;
		case "Arcane Ward":
			description = "";
			break;
		case "Projected Ward":
			description = "";
			break;
		case "Improved Abjuration":
			description = "";
			break;
		case "Spell Resistance":
			description = "";
			break;
			// school of conjuration
		case "Conjuration Savant":
			description = "";
			break;
		case "Minor Conjuration":
			description = "";
			break;
		case "Benign Transposition":
			description = "";
			break;
		case "Focused Conjuration":
			description = "";
			break;
		case "Durable Summons":
			description = "";
			break;
			// school of divination
		case "Divination Savant":
			description = "";
			break;
		case "Portent":
			description = "";
			break;
		case "Expert Divination":
			description = "";
			break;
		case "The Third Eye":
			description = "";
			break;
		case "Greater Portent":
			description = "";
			break;
			// school of enchantment
		case "Enchantment Savant":
			description = "";
			break;
		case "Hypnotic Gaze":
			description = "";
			break;
		case "Instinctive Charm":
			description = "";
			break;
		case "Split Enchantment":
			description = "";
			break;
		case "Alter Memories":
			description = "";
			break;
			// school of evocation
		case "Evocation Savant":
			description = "";
			break;
		case "Sculpt Spells":
			description = "";
			break;
		case "Potent Cantrip":
			description = "";
			break;
		case "Empowered Evocation":
			description = "";
			break;
		case "Overchannel":
			description = "";
			break;
			// school of illusion
		case "Illusion Savant":
			description = "";
			break;
		case "Improved Minor Illusion":
			description = "";
			break;
		case "Malleable Illusions":
			description = "";
			break;
		case "Illusory Self":
			description = "";
			break;
		case "Illusory Reality":
			description = "";
			break;
			// school of necromancy
		case "Necromancy Savant":
			description = "";
			break;
		case "Grim Harvest":
			description = "";
			break;
		case "Undead Thralls":
			description = "";
			break;
		case "Inured to Undeath":
			description = "";
			break;
		case "Command Undead":
			description = "";
			break;
			// school of transmutation
		case "Transmutation Savant":
			description = "";
			break;
		case "Minor Alchemy":
			description = "";
			break;
		case "Transmuter's Stone":
			description = "";
			break;
		case "Shapechanger":
			description = "";
			break;
		case "Master Transmuter":
			description = "";
			break;
			// customization feats
		case "Alert":
			description = "";
			break;
		case "Athlete":
			description = "";
			break;
		case "Actor":
			description = "";
			break;
		case "Charger":
			description = "";
			break;
		case "Crossbow Expert":
			description = "";
			break;
		case "Defensive Duelist":
			description = "";
			break;
		case "Dual Wielder":
			description = "";
			break;
		case "Dungeon Delver":
			description = "";
			break;
		case "Durable":
			description = "";
			break;
		case "Elemental Adept":
			description = "";
			break;
		case "Grappler":
			description = "";
			break;
		case "Great Weapon Master":
			description = "";
			break;
		case "Healer":
			description = "";
			break;
		case "Heavily Armored":
			description = "";
			break;
		case "Heavy Armor Master":
			description = "";
			break;
		case "Inspiring Leader":
			description = "";
			break;
		case "Keen Mind":
			description = "";
			break;
		case "Lightly Armored":
			description = "";
			break;
		case "Linguist":
			description = "";
			break;
		case "Lucky (special)":
			description = "";
			break;
		case "Mage Slayer":
			description = "";
			break;
		case "Magic Initiate":
			description = "";
			break;
		case "Martial Adept":
			description = "";
			break;
		case "Medium Armor Master":
			description = "";
			break;
		case "Mobile":
			description = "";
			break;
		case "Moderately Armored":
			description = "";
			break;
		case "Mounted Combatant":
			description = "";
			break;
		case "Observant":
			description = "";
			break;
		case "Polearm Master":
			description = "";
			break;
		case "Resilient":
			description = "";
			break;
		case "Ritual Caster":
			description = "";
			break;
		case "Savage Attacker":
			description = "";
			break;
		case "Sentinel":
			description = "";
			break;
		case "Sharpshooter":
			description = "";
			break;
		case "Shield Master":
			description = "";
			break;
		case "Skilled":
			description = "";
			break;
		case "Skulker":
			description = "";
			break;
		case "Spell Sniper":
			description = "";
			break;
		case "Tavern Brawler":
			description = "";
			break;
		case "Tough":
			description = "";
			break;
		case "War Caster":
			description = "";
			break;
		case "Weapon Master":
			description = "";
			break;
			
		default:
			found = false;
			break;
		}
		
		
		return found;
	}
	
	// black, blue, brass, bronze, copper, gold, green, red, silver, white
	/**private void ancestry(int c) {
		String color = "";
		String damage = "";
		String breath = "";
		switch (c) {
		case 0:
			color = "black";
			damage = "acid";
			breath = "5 by 30 ft. line (Dex. save)";
		case 1: 
			color = "blue";
			damage = "lightning";
			breath = "5 by 30 ft. line (Dex. save)";
		case 2: 
			color = "brass";
			damage = "fire";
			breath = "5 by 30 ft. line (Dex. save)";
		case 3: 
			color = "bronze";
			damage = "lightning";
			breath = "5 by 30 ft. line (Dex. save)";
		case 4: 
			color = "copper";
			damage = "acid";
			breath = "5 by 30 ft. line (Dex. save)";
		case 5: 
			color = "gold";
			damage = "fire";
			breath = "15 ft. cone (Dex. save)";
		case 6: 
			color = "green";
			damage = "poison";
			breath = "15 ft. cone (Con. save)";
		case 7: 
			color = "red";
			damage = "fire";
			breath = "15 ft. cone (Dex. save)";
		case 8: 
			color = "silver";
			damage = "cold";
			breath = "15 ft. cone (Con. save)";
		case 9: 
			color = "white";
			damage = "cold";
			breath = "15 ft. cone (Con. save)";
		default:
			break;
		}
		
		description = "You have draconic ancestry (" + color + "). Your breath weapon deals " + damage + " damage in a " + breath + ".";
	}

	private void rage(int level) {
		String rages = "";
		int damage = -1;
		switch (level) {
		case 1:
			rages = "2";
			damage = 2;
			break;
		case 3:
			rages = "3";
			damage = 2;
			break;
		case 6:
			rages = "4";
			damage = 2;
			break;
		case 9:
			rages = "4";
			damage = 3;
			break;
		case 12:
			rages = "5";
			damage = 3;
			break;
		case 16:
			rages = "5";
			damage = 4;
			break;
		case 17:
			rages = "6";
			damage = 4;
			break;
		case 20:
			rages = "unlimited";
			damage = 4;
			break;
		default:
			break;
		}
		description = "In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action.\n"
				+ "While raging, you gain the following benefits if you aren’t wearing heavy armor:\n"
				+ "- You have advantage on Strength checks and Strength saving throws.\n"
				+ "- When you make a melee weapon attack using Strength, you gain + " + damage + " bonus damage to the damage roll.\n"
						+ "- You have resistance to bludgeoning, piercing, and slashing damage.\n"
						+ "If you are able to cast spells, you can’t cast them or concentrate on them while raging.\n"
						+ "Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you "
						+ "haven’t attacked a hostile creature since your last turn or taken damage since then. You can also end your rage on your turn as a bonus action.\n"
						+ "You may rage " + rages + " times before you must finish a long rest to rage again.";
	}

	private void brutalCritical(int level) {
		String num = "";
		String d = "dice";
		switch (level) {
		case 9:
			num = "one";
			d = "die";
			break;
		case 13:
			num = "two";
			break;
		case 17:
			num = "three";
			break;
		default:
			break;
		}
		description = "You can roll " + num + " additional weapon damage " + d + " when determing the extra damage for a critical hit with a melee attack.";
	}
	
	private void bardicInspiration(int level) {
		int die = -1;
		switch (level) {
		case 1:
			die = 6;
			break;
		case 5:
			die = 8;
			break;
		case 10:
			die = 10;
			break;
		case 15:
			die = 12;
			break;
		default:
			break;
		}
		description = "You can inspire others through stirring words or music. To do so, you use a bonus action on your turn to choose "
				+ "one creature other than yourself within 60 feet of you who can hear you. That creature gains one Bardic Inspiration die, a d" + die + ".\n"
						+ "Once within the next 10 minutes, the creature can roll the die and add the number rolled to one ability check, "
						+ "attack roll, or saving throw it makes. The creature can wait until after it rolls the d20 before deciding to use the "
						+ "Bardic Inspiration die, but must decide before the DM says whether the roll succeeds or fails. Once the Bardic "
						+ "Inspiration die is rolled, it is lost. A creature can have only one Bardic Inspiration die at a time.\n"
						+ "You can use this feature a number of times equal to your Charisma modifier (a minimum of once). You "
						+ "regain any expended uses when you finish a long rest.";
	}
	
	private void songOfRest(int level) {
		int die = -1;
		switch (level) {
		case 2:
			die = 6;
			break;
		case 9:
			die = 8;
			break;
		case 13:
			die = 10;
			break;
		case 17:
			die = 12;
			break;
		default:
			break;
		}
		description = "Beginning at 2nd level, you can use soothing music or oration to help revitalize your wounded allies during "
				+ "a short rest. If you or any friendly creatures who can hear your perform ance regain hit points at the end of "
				+ "the short rest, each of those creatures regains an extra 1d" + die + " hit points.";
	}*/
	
}
