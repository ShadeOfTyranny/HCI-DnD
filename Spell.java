package model;

public class Spell {
	
	// fields
	String name, castTime, range, components, duration, description;
	int level;
	boolean ritual;
	
	public Spell() {
		name = "";
		castTime = "";
		range = "";
		components = "";
		duration = "";
		description = "";
		level = 0;
		ritual = false;
	}
	
	public Spell(String s) {
		name = s;
		if (!match()) {
			// do nothing?
		}
	}
	
	public Spell(String name, String castTime, String range, String components, String duration, String description, int level, boolean ritual) {
		this.name = name;
		this.castTime = castTime;
		this.range = range;
		this.components = components;
		this.duration = duration;
		this.description = description;
		this.level = level;
		this.ritual = ritual;
	}
	
	private boolean match() {
		boolean b = true;
		switch (name) {
		case "Acid Splash":
			description = "You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. "
					+ "A target must succeed on a Dexterity saving throw or take 1d6 acid damage.\n"
					+ "This spell’s damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).";
			setSpell("1 action", "60 feet", "V, S", "Instantaneous", 0, false);
			break;
		case "Aid":
			description = "Your spell bolsters your allies with toughness and resolve. Choose up to three creatures within range. "
					+ "Each target’s hit point maximum and current hit points increase by 5 for the duration.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 3rd level or higher, a target’s hit points increase by an additional 5 "
					+ "for each slot level above 2nd.";
			setSpell("1 action", "30 feet", "V, S, M (a tiny strip of white cloth)", "8 hours", 2, false);
			break;
		case "Alarm":
			description = "You set an alarm against unwanted intrusion. Choose a door, a window, or an area within range that is no larger than a 20-foot cube. "
					+ "Until the spell ends, an alarm alerts you whenever a Tiny or larger creature touches or enters the warded area. When you cast the spell, "
					+ "you can designate creatures that won’t set off the alarm. You also choose whether the alarm is mental or audible."
					+ "A mental alarm alerts you with a ping in your mind if you are within 1 mile of the warded area. This ping awakens you if you are sleeping."
					+ "An audible alarm produces the sound of a hand bell for 10 seconds within 60 feet.";
			setSpell("1 minute", "30 feet", "V, S, M (a tiny bell and a piece of fine silver wire)", "8 hours", 1, true);
			break;
		case "Alter Self":
			description = "You assume a different form. When you cast the spell, choose one of the following options, the effects of which last for the duration of the spell. "
					+ "While the spell lasts, you can end one option as an action to gain the benefits of a different one.\n"
					+ "Aquatic Adaptation. You adapt your body to an aquatic environment, sprouting gills and growing webbing between your fingers. "
					+ "You can breathe underwater and gain a swimming speed equal to your walking speed.\n"
					+ "Change Appearance. You transform your appearance. You decide what you look like, including your height, weight, facial features, sound of your voice, "
					+ "hair length, coloration, and distinguishing characteristics, if any. You can make yourself appear as a member of another race, though none of your "
					+ "statistics change. You also can’t appear as a creature of a different size than you, and your basic shape stays the same; if you're bipedal, "
					+ "you can’t use this spell to become quadrupedal, for instance. At any time for the duration of the spell, you can use your action to change your "
					+ "appearance in this way again\n"
					+ "Natural Weapons. You grow claws, fangs, spines, horns, or a different natural weapon of your choice. Your unarmed strikes deal 1d6 bludgeoning, "
					+ "piercing, or slashing damage, as appropriate to the natural weapon you chose, and you are proficient with your unarmed strikes. Finally, the "
					+ "natural weapon is magic and you have a +1 bonus to the attack and damage rolls you make using it.";
			setSpell("1 action", "Self", "V, S", "Concentration, up to 1 hour", 2, false);
			break;
		case "Animal Friendship":
			description = "This spell lets you convince a beast that you mean it no harm. Choose a beast that you can see within range. It must see and hear you. "
					+ "If the beast’s Intelligence is 4 or higher, the spell fails. Otherwise, the beast must succeed on a Wisdom saving throw or be charmed by you for "
					+ "the spell’s duration. If you or one of your companions harms the target, the spells ends.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, you can affect one additional beast for each slot level above 1st.";
			setSpell("1 action", "30 feet", "V, S, M (a morsel of food)", "24 hours", 1, false);
			break;
		case "Animal Messenger":
			description = "By means of this spell, you use an animal to deliver a message. Choose a Tiny beast you can see within range, such as a squirrel, a blue jay, "
					+ "or a bat. You specify a location, which you must have visited, and a recipient who matches a general description, such as “a man or woman dressed "
					+ "in the uniform of the town guard” or “a red-haired dwarf wearing a pointed hat.” You also speak a message of up to twenty-five words. "
					+ "The target beast travels for the duration of the spell toward the specified location, covering about 50 miles per 24 hours for a flying messenger, "
					+ "or 25 m iles for other animals.\n"
					+ "When the messenger arrives, it delivers your message to the creature that you described, replicating the sound of your voice. "
					+ "The messenger speaks only to a creature matching the description you gave. If the messenger doesn’t reach its destination before the spell ends, "
					+ "the message is lost, and the beast makes its way back to where you cast this spell.\n"
					+ "At Higher Levels. If you cast this spell using a spell slot of 3nd level or higher, the duration of the spell increases by 48 hours for each slot "
					+ "level above 2nd.";
			setSpell("1 action", "30 feet", "V, S, M (a morsel of food)", "24 hours", 2, true);
			break;
		case "Animal Shapes":
			description = "Your magic turns others into beasts. Choose any number of willing creatures that you can see within range. You transform each target into the "
					+ "form of a Large or smaller beast with a challenge rating of 4 or lower. On subsequent turns, you can use your action to transform affected creatures "
					+ "into new forms.\n"
					+ "The transformation lasts for the duration for each target, or until the target drops to 0 hit points or dies. You can choose a different form for "
					+ "each target. A target’s game statistics are replaced by the statistics of the chosen beast, though the target retains its alignment and "
					+ "Intelligence, Wisdom , and Charisma scores. The target assumes the hit points of its new form, and when it reverts to its normal form, it returns to "
					+ "the number of hit points it had before it transformed. If it reverts as a result of dropping to 0 hit points, any excess damage carries over to "
					+ "its normal form. As long as the excess damage doesn’t reduce the creature’s normal form to 0 hit points, it isn’t knocked unconscious. "
					+ "The creature is limited in the actions it can perform by the nature of its new form, and it can’t speak or cast spells.\n"
					+ "The target’s gear melds into the new form. The target can’t activate, wield, or otherwise benefit from any of its equipment.";
			setSpell("1 action", "30 feet", "V, S", "Concentration, up to 24 hours", 8, false);
			break;
		case "Animate Dead":
			description = "This spell creates an undead servant. Choose a pile of bones or a corpse of a Medium or Small humanoid within range. Your spell imbues the target "
					+ "with a foul mimicry of life, raising it as an undead creature. The target becomes a skeleton if you chose bones or a zombie if you chose a corpse "
					+ "(the DM has the creature’s game statistics).\n"
					+ "On each of your turns, you can use a bonus action to mentally command any creature you made with this spell if the creature is within 60 feet of you "
					+ "(if you control multiple creatures, you can command any or all of them at the same time, issuing the same command to each one). You decide what "
					+ "action the creature will take and where it will move during its next turn, or you can issue a general command, such as to guard a particular chamber "
					+ "or corridor. If you issue no commands, the creature only defends itself against hostile creatures. Once given an order, the creature continues to "
					+ "follow it until its task is complete.\n"
					+ "The creature is under your control for 24 hours, after which it stops obeying any command you’ve given it. To maintain control of the creature for "
					+ "another 24 hours, you must cast this spell on the creature again before the current 24-hour period ends. This use of the spell reasserts your "
					+ "control over up to four creatures you have animated with this spell, rather than animating a new one.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 4th level or higher, you animate or reassert control over two additional undead "
					+ "creatures for each slot level above 3rd. Each of the creatures must come from a different corpse or pile of bones.";
			setSpell("1 minute", "10 feet", "V, S, M (a drop of blood, a piece of flesh, and a pinch of bone dust)", "Instantaneous", 3, false);
			break;
		case "Animate Objects":
			description = "Objects come to life at your command. Choose up to ten nonmagical objects within range that are not being worn or carried. Medium targets count "
					+ "as two objects, Large targets count as four objects, Huge targets count as eight objects. You can’t animate any object larger than Huge. "
					+ "Each target animates and becomes a creature under your control until the spell ends or until reduced to 0 hit points.\n"
					+ "As a bonus action, you can mentally command any creature you made with this spell if the creature is within 500 feet of you (if you control multiple "
					+ "creatures, you can command any or all of them at the same time, issuing the same command to each one). You decide what action the creature will take "
					+ "and where it will move during its next turn, or you can issue a general command, such as to guard a particular chamber or corridor. If you issue no "
					+ "commands, the creature only defends itself against hostile creatures. Once given an order, the creature continues to follow it until its task is "
					+ "complete.\n"
					+ "An animated object is a construct with AC, hit points, attacks, Strength, and Dexterity determined by its size. Its Constitution is 10 and its "
					+ "Intelligence and Wisdom are 3, and its Charisma is 1. Its speed is 30 feet; if the object lacks legs or other appendages it can use for locomotion, "
					+ "it instead has a flying speed of 30 feet and can hover. If the object is securely attached to a surface or a larger object, such as a chain bolted "
					+ "to a wall, its speed is 0. It has blindsight with a radius of 30 feet and is blind beyond that distance. When the animated object drops to 0 "
					+ "hit points, it reverts to its original object form, and any remaining damage carries over to its original object form.\n"
					+ "If you command an object to attack, it can make a single melee attack against a creature within 5 feet of it. It makes a slam attack with an attack "
					+ "bonus and bludgeoning damage determined by its size. The DM might rule that a specific object inflicts slashing or piercing damage based on its form.\n"
					+ "At Higher Levels. If you cast this spell using a spell slot of 6th level or higher, you can animate two additional objects for each slot level above 5th.";
			setSpell("1 action", "120 feet", "V, S", "Concentration, up to 1 minute", 5, false);
			break;
		case "Antilife Spell":
			description = "A shimmering barrier extends out from you in a 10-foot radius and moves with you, remaining centered on you and hedging out creatures other "
					+ "than undead and constructs. The barrier lasts for the duration.\n"
					+ "The barrier prevents an affected creature from passing or reaching through. An affected creature can cast spells or make attacks with ranged or reach "
					+ "weapons through the barrier.\n"
					+ "If you move so that an affected creature is forced to pass through the barrier, the spell ends.";
			setSpell("1 action", "Self (10-foot radius)", "V, S", "Concentration, up to 1 hour", 5, false);
			break;
		case "Antimagic Field":
			description = "A 10-foot-radius invisible sphere of antimagic surrounds you. This area is divorced from the magical energy that suffuses the multiverse. "
					+ "Within the sphere, spells can’t be cast, summoned creatures disappear, and even magic items become mundane. Until the spell ends, the sphere moves "
					+ "with you, centered on you.\n"
					+ "Spells and other magical effects, except those created by an artifact or a deity, are suppressed in the sphere and can’t protrude into it. "
					+ "A slot expended to cast a suppressed spell is consumed. While an effect is suppressed, it doesn’t function, but the time it spends suppressed counts "
					+ "against its duration.\n"
					+ "Targeted Effects. Spells and other magical effects, such as magic missile and charm person, that target a creature or an object in the sphere have "
					+ "no effect on that target.\n"
					+ "Areas of Magic. The area of another spell or magical effect, such as fireball, can’t extend into the sphere. If the sphere overlaps an area of magic, "
					+ "the part of the area that is covered by the sphere is suppressed. For example, the flames created by a wall of fire are suppressed within the sphere, "
					+ "creating a gap in the wall if the overlap is large enough.\n"
					+ "Spells. Any active spell or other magical effect on a creature or an object in the sphere is suppressed while the creature or object is in it.\n"
					+ "Magic Items. The properties and powers of magic items are suppressed in the sphere. For example, a +1 longsword in the sphere functions as a "
					+ "nonmagical longsword.\n"
					+ "A magic weapon’s properties and powers are suppressed if it is used against a target in the sphere or wielded by an attacker in the sphere. If a "
					+ "magic weapon or a piece of magic ammunition fully leaves the sphere (for example, if you fire a magic arrow or throw a magic spear at a target "
					+ "outside the sphere), the magic of the item ceases to be suppressed as soon as it exits.\n"
					+ "Magical Travel. Teleportation and planar travel fail to work in the sphere, whether the sphere is the destination or the departure point for such "
					+ "magical travel. A portal to another location, world, or plane of existence, as well as an opening to an extradimensional space such as that "
					+ "created by the rope trick spell, temporarily closes while in the sphere.\n"
					+ "Creatures and Objects. A creature or object summoned or created by magic temporarily winks out of existence in the sphere. Such a creature "
					+ "instantly reappears once the space the creature occupied is no longer within the sphere.\n"
					+ "Dispel Magic. Spells and magical effects such as dispel magic have no effect on the sphere. Likewise, the spheres created by different antimagic "
					+ "field spells don’t nullify each other.";
			setSpell("1 action", "Self (10-foot-radius sphere)", "V, S, M (a pinch of powdered iron or iron filings)", "Concentration, up to 1 hour", 8, false);
			break;
		case "Antipathy/Sympathy":
			description = "This spell attracts or repels creatures of your choice. You target something within range, either a Huge or smaller object or creature or an "
					+ "area that is no larger than a 200-foot cube. Then specify a kind of intelligent creature, such as red dragons, goblins, or vampires. You invest the "
					+ "target with an aura that either attracts or repels the specified creatures for the duration. Choose antipathy or sympathy as the aura’s effect.\n"
					+ "Antipathy. The enchantment causes creatures of the kind you designated to feel an intense urge to leave the area and avoid the target. When such a "
					+ "creature can see the target or comes within 60 feet of it, the creature must succeed on a Wisdom saving throw or become frightened. The creature "
					+ "remains frightened while it can see the target or is within 60 feet of it. While frightened by the target, the creature must use its movement to "
					+ "move to the nearest safe spot from which it can’t see the target. If the creature moves more than 60 feet from the target and can’t see it, "
					+ "the creature is no longer frightened, but the creature becomes frightened again if it regains sight of the target or moves within 60 feet of it.\n"
					+ "Sympathy. The enchantment causes the specified creatures to feel an intense urge to approach the target while within 60 feet of it or able to see it. "
					+ "When such a creature can see the target or comes within 60 feet of it, the creature must succeed on a Wisdom saving throw or use its movement "
					+ "on each of its turns to enter the area or move within reach of the target. When the creature has done so, it can’t willingly move away from the target.\n"
					+ "If the target damages or otherwise harms an affected creature, the affected creature can make a Wisdom saving throw to end the effect, as "
					+ "described below.\n"
					+ "Ending the Effect. If an affected creature ends its turn while not within 60 feet of the target or able to see it, the creature makes a Wisdom "
					+ "saving throw. On a successful save, the creature is no longer affected by the target and recognizes the feeling of repugnance or attraction as "
					+ "magical. In addition, a creature affected by the spell is allowed another Wisdom saving throw every 24 hours while the spell persists.\n"
					+ "A creature that successfully saves against this effect is immune to it for 1 minute, after which time it can be affected again.";
			setSpell("1 hour", "60 feet", "V, S, M (either a lump of alum soaked in vinegar for the antipathy effect or a drop of honey for the sympathy effect)", 
					"10 days", 8, false);
			break;
		case "Arcane Eye":
			description = "You create an invisible, magical eye within range that hovers in the air for the duration.\n"
					+ "You mentally receive visual information from the eye, which has normal vision and darkvision out to 30 feet. The eye can look in every direction.\n"
					+ "As an action, you can move the eye up to 30 feet in any direction. There is no limit to how far away from you the eye can move, but it can’t enter "
					+ "another plane of existence. A solid barrier blocks the eye’s movement, but the eye can pass through an opening as small as 1 inch in diameter.";
			setSpell("1 action", "30 feet", "V, S, M (a bit of bat fur)", "Concentration, up to 1 hour", 4, false);
			break;
		case "Arcane Gate":
			description = "You create linked teleportation portals that remain open for the duration. Choose two points on the ground that you can see, one point within "
					+ "10 feet of you and one point within 500 feet of you. A circular portal, 10 feet in diameter, opens over each point. If the portal would open in the "
					+ "space occupied by a creature, the spell fails, and the casting is lost.\n"
					+ "The portals are two-dimensional glowing rings filled with mist, hovering inches from the ground and perpendicular to it at the points you choose. "
					+ "A ring is visible only from one side (your choice), which is the side that functions as a portal.\n"
					+ "Any creature or object entering the portal exits from the other portal as if the two were adjacent to each other; passing through a portal from the "
					+ "nonportal side has no effect. The mist that fills each portal is opaque and blocks vision through it. On your turn, you can rotate the rings as a "
					+ "bonus action so that the active side faces in a different direction.";
			setSpell("1 action", "500 feet", "V, S", "Concentration, up to 10 minutes", 6, false);
			break;
		case "Arcane Lock":
			description = "You touch a closed door, window, gate, chest, or other entryway, and it becomes locked for the duration. You and the creatures you designate "
					+ "when you cast this spell can open the object normally. You can also set a password that, when spoken within 5 feet of the object, suppresses this "
					+ "spell for 1 minute. Otherwise, it is impassable until it is broken or the spell is dispelled or suppressed. Casting knock on the object suppresses "
					+ "arcane lock for 10 minutes.\n"
					+ "While affected by this spell, the object is more difficult to break or force open; the DC to break it or pick any locks on it increases by 10.";
			setSpell("1 action", "Touch", "V, S, M (gold dust worth at least 25 gp, which the spell consumes)", "Until dispelled", 2, false);
			break;
		case "Armor of Agathys":
			description = "A protective magical force surrounds you, manifesting as a spectral frost that covers you and your gear. You gain 5 temporary hit points for the "
					+ "duration. If a creature hits you with a melee attack while you have these hit points, the creature takes 5 cold damage.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, both the temporary hit points and the cold damage increase by "
					+ "5 for each slot level above 1st.";
			setSpell("1 action", "Self", "V, S, M (a cup of water)", "1 hour", 1, false);
			break;
		case "Arms of Hadar":
			description = "You invoke the power of Hadar, the Dark Hunger. Tendrils of dark energy erupt from you and batter all creatures within 10 feet of you. "
					+ "Each creature in that area must make a Strength saving throw. On a failed save, a target takes 2d6 necrotic damage and can’t take reactions until its "
					+ "next turn. On a successful save, the creature takes half damage, but suffers no other effect.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.";
			setSpell("1 action", "Self (10-foot radius)", "V, S", "Instantaneous", 1, false);
			break;
		case "Astral Projection":
			description = "You and up to eight willing creatures within range project your astral bodies into the Astral Plane (the spell fails and the casting is wasted "
					+ "if you are already on that plane). The material body you leave behind is unconscious and in a state of suspended animation; it doesn’t need food or "
					+ "air and doesn’t age.\n"
					+ "Your astral body resembles your mortal form in almost every way, replicating your game statistics and possessions. The principal difference is the "
					+ "addition of a silvery cord that extends from between your shoulder blades and trails behind you, fading to invisibility after 1 foot. This cord is "
					+ "your tether to your material body. As long as the tether remains intact, you can find your way home. If the cord is cut—something that can happen "
					+ "only when an effect specifically states that it does—your soul and body are separated, killing you instantly.\n"
					+ "Your astral form can freely travel through the Astral Plane and can pass through portals there leading to any other plane. If you enter a new plane "
					+ "or return to the plane you were on when casting this spell, your body and possessions are transported along the silver cord, allowing you to re-enter "
					+ "your body as you enter the new plane. Your astral form is a separate incarnation. Any damage or other effects that apply to it have no effect on your "
					+ "physical body, nor do they persist when you return to it.\n"
					+ "The spell ends for you and your companions when you use your action to dismiss it. When the spell ends, the affected creature returns to its physical "
					+ "body, and it awakens.\n"
					+ "The spell might also end early for you or one of your companions. A successful dispel magic spell used against an astral or physical body ends the "
					+ "spell for that creature. If a creature’s original body or its astral form drops to 0 hit points, the spell ends for that creature. If the spell ends "
					+ "and the silver cord is intact, the cord pulls the creature’s astral form back to its body, ending its state of suspended animation.\n"
					+ "If you are returned to your body prematurely, your companions remain in their astral forms and must find their own way back to their bodies, "
					+ "usually by dropping to 0 hit points.";
			setSpell("1 hour", "10 feet", "V, S, M (for each creature you affect with this spell, you must provide one jacinth worth at least 1,000 gp and one "
					+ "ornately carved bar of silver worth at least 100 gp, all of which the spell consumes)", "Special", 9, false);
			break;
		case "Augury":
			description = "By casting gem-inlaid sticks, rolling dragon bones, laying out ornate cards, or employing some other divining tool, you receive an omen from an "
					+ "otherworldly entity about the results of a specific course of action that you plan to take within the next 30 minutes. The DM chooses from the "
					+ "following possible omens:\n"
					+ "Weal, for good results\n"
					+ "Woe, for bad results\n"
					+ "Weal and woe, for both good and bad results\n"
					+ "Nothing, for results that aren't especially good or bad\n"
					+ "The spell doesn’t take into account any possible circumstances that might change the outcome, such as the casting of additional spells or the loss "
					+ "or gain of a companion.\n"
					+ "If you cast the spell two or more times before completing your next long rest, there is a cumulative 25 percent chance for each casting after the "
					+ "first that you get a random reading. The DM makes this roll in secret.";
			setSpell("1 minute", "Self", "V, S, M (specially marked sticks, bones, or similar tokens worth at least 25 gp)", "Instantaneous", 2, true);
			break;
		case "Aura of Life":
			description = "Life-preserving energy radiates from you in an aura with a 30-foot radius. Until the spell ends, the aura moves with you, centered on you. "
					+ "Each nonhostile creature in the aura (including you) has resistance to necrotic damage, and its hit point maximum can't be reduced. In addition, "
					+ "a nonhostile, living creature regains 1 hit point when it starts its turn in the aura with 0 hit points.";
			setSpell("1 action", "Self (30-foot radius)", "V", "Concentration, up to 10 minutes", 4, false);
			break;
		case "Aura of Purity":
			description = "Purifying energy radiates from you in an aura with a 30-foot radius. Until the spell ends, the aura moves with you, centered on you. "
					+ "Each nonhostile creature in the aura (including you) can’t become diseased, has resistance to poison damage, and has advantage on saving throws "
					+ "against effects that cause any of the following conditions: blinded, charmed, deafened, frightened, paralyzed, poisoned, and stunned.";
			setSpell("1 action", "Self (30-foot radius)", "V", "Concentration, up to 10 minutes", 4, false);
			break;
		case "Aura of Vitality":
			description = "Healing energy radiates from you in an aura with a 30-foot radius. Until the spell ends, the aura moves with you, centered on you. You can use "
					+ "a bonus action to cause one creature in the aura (including you) to regain 2d6 hit points.";
			setSpell("1 action", "Self (30-foot radius)", "V", "Concentration, up to 1 minute", 3, false);
			break;
		case "Awaken":
			description = "After spending the casting time tracing magical pathways within a precious gemstone, you touch a Huge or smaller beast or plant. The target must "
					+ "have either no Intelligence score or an Intelligence of 3 or less. The target gains an Intelligence of 10. The target also gains the ability to speak "
					+ "one language you know. If the target is a plant, it gains the ability to move its limbs, roots, vines, creepers, and so forth, and it gains senses "
					+ "similar to a human’s. Your DM chooses statistics appropriate for the awakened plant, such as the statistics for the awakened shrub or the awakened "
					+ "tree.\n"
					+ "The awakened beast or plant is charmed by you for 30 days or until you or your companions do anything harmful to it. When the charmed condition ends, "
					+ "the awakened creature chooses whether to remain friendly to you, based on how you treated it while it was charmed.";
			setSpell("8 hours", "Touch", "V, S, M (an agate worth at least 1,000 gp, which the spell consumes)", "Instantaneous", 5, false);
			break;
		case "Bane":
			description = "Up to three creatures of your choice that you can see within range must make Charisma saving throws. Whenever a target that fails this saving "
					+ "throw makes an attack roll or a saving throw before the spell ends, the target must roll a d4 and subtract the number rolled from the attack roll "
					+ "or saving throw.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level "
					+ "above 1st.";
			setSpell("1 action", "30 feet", "V, S, M (a drop of blood)", "Concentration, up to 1 minute", 1, false);
			break;
		case "Banishing Smite":
			description = "The next time you hit a creature with a weapon attack before this spell ends, your weapon crackles with force, and the attack deals an extra "
					+ "5d10 force damage to the target. Additionally, if this attack reduces the target to 50 hit points or fewer, you banish it. If the target is native "
					+ "to a different plane of existence than the one you’re on, the target disappears, returning to its home plane. If the target is native to the "
					+ "plane you’re on, the creature vanishes into a harmless demiplane. While there, the target is incapacitated. It remains there until the spell ends, "
					+ "at which point the target reappears in the space it left or in the nearest unoccupied space if that space is occupied.";
			setSpell("1 bonus action", "Self", "V", "Concentration, up to 1 minute", 5, false);
			break;
		case "Banishment":
			description = "You attempt to send one creature that you can see within range to another plane of existence. The target must succeed on a Charisma saving throw "
					+ "or be banished.\n"
					+ "If the target is native to the plane of existence you’re on, you banish the target to a harmless demiplane. While there, the target is incapacitated. "
					+ "The target remains there until the spell ends, at which point the target reappears in the space it left or in the nearest unoccupied space if that "
					+ "space is occupied.\n"
					+ "If the target is native to a different plane of existence than the one you’re on, the target is banished with a faint popping noise, returning to its "
					+ "home plane. If the spell ends before 1 minute has passed, the target reappears in the space it left or in the nearest unoccupied space if that space "
					+ "is occupied. Otherwise, the target doesn't return.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 5th level or higher, you can target one additional creature for each slot level "
					+ "above 4th.";
			setSpell("1 action", "60 feet", "V, S, M (an item distasteful to the target)", "Concentration, up to 1 minute", 4, false);
			break;
		case "Barkskin":
			description = "You touch a willing creature. Until the spell ends, the target’s skin has a rough, bark-like appearance, and the target’s AC can’t be less than "
					+ "16, regardless of what kind of armor it is wearing.";
			setSpell("1 action", "Touch", "V, S, M (a handful of oak bark)", "Concentration, up to 1 hour", 2, false);
			break;
		case "Beacon of Hope":
			description = "This spell bestows hope and vitality. Choose any number of creatures within range. For the duration, each target has advantage on Wisdom saving "
					+ "throws and death saving throws, and regains the maximum number of hit points possible from any healing.";
			setSpell("1 action", "30 feet", "V, S", "Concentration, up to 1 minute", 3, false);
			break;
		case "Beast Sense":
			description = "You touch a willing beast. For the duration of the spell, you can use your action to see through the beast’s eyes and hear what it hears, and "
					+ "continue to do so until you use your action to return to your normal senses. While perceiving through the beast’s senses, you gain the benefits of "
					+ "any special senses possessed by that creature, though you are blinded and deafened to your own surroundings.";
			setSpell("1 action", "Touch", "V, S", "Concentration, up to 1 minute", 3, false);
			break;
		case "Bestow Curse":
			description = "You touch a creature, and that creature must succeed on a Wisdom saving throw or become cursed for the duration of the spell. When you cast "
					+ "this spell, choose the nature of the curse from the following options:\n"
					+ "Choose one ability score. While cursed, the target has disadvantage on ability checks and saving throws made with that ability score.\n"
					+ "While cursed, the target has disadvantage on attack rolls against you.\n"
					+ "While cursed, the target must make a Wisdom saving throw at the start of each of its turns. If it fails, it wastes its action that turn doing nothing.\n"
					+ "While the target is cursed, your attacks and spells deal an extra 1d8 necrotic damage to the target.\n"
					+ "A remove curse spell ends this effect. At the DM ’s option, you may choose an alternative curse effect, but it should be no more powerful than those "
					+ "described above. The DM has final say on such a curse’s effect.\n"
					+ "At Higher Levels. If you cast this spell using a spell slot of 4th level or higher, the duration is concentration, up to 10 minutes. If you use a "
					+ "spell slot of 5th level or higher, the duration is 8 hours. If you use a spell slot of 7th level or higher, the duration is 24 hours. "
					+ "If you use a 9th level spell slot, the spell lasts until it is dispelled. Using a spell slot of 5th level or higher grants a duration that doesn’t "
					+ "require concentration.";
			setSpell("1 action", "Touch", "V, S", "Concentration, up to 1 minute", 3, false);
			break;
		case "Bigby's Hand":
			description = "You create a Large hand of shimmering, translucent force in an unoccupied space that you can see within range. The hand lasts for the spell’s "
					+ "duration, and it moves at your command, mimicking the movements of your own hand.\n"
					+ "The hand is an object that has AC 20 and hit points equal to your hit point maximum. If it drops to 0 hit points, the spell ends. It has a Strength "
					+ "of 26 (+8) and a Dexterity o f 10 (+0). The hand doesn’t fill its space.\n"
					+ "When you cast the spell and as a bonus action on your subsequent turns, you can move the hand up to 60 feet and then cause one of the following "
					+ "effects with it.\n"
					+ "Clenched Fist. The hand strikes one creature or object within 5 feet of it. Make a melee spell attack for the hand using your game statistics. On a "
					+ "hit, the target takes 4d8 force damage.\n"
					+ "Forceful Hand. The hand attempts to push a creature within 5 feet of it in a direction you choose. Make a check with the hand’s Strength contested by "
					+ "the Strength (Athletics) check of the target. If the target is Medium or smaller, you have advantage on the check. If you succeed, the hand pushes "
					+ "the target up to 5 feet plus a number of feet equal to five times your spellcasting ability modifier. The hand moves with the target to remain within "
					+ "5 feet of it.\n"
					+ "Grasping Hand. The hand attempts to grapple a Huge or smaller creature within 5 feet of it. You use the hand’s Strength score to resolve the grapple. "
					+ "If the target is Medium or smaller, you have advantage on the check. While the hand is grappling the target, you can use a bonus action to have the "
					+ "hand crush it. When you do so, the target takes bludgeoning damage equal to 2d6 + your spellcasting ability modifier.\n"
					+ "Interposing Hand. The hand interposes itself between you and a creature you choose until you give the hand a different command. The hand moves to "
					+ "stay between you and the target, providing you with half cover against the target. The target can't move through the hand’s space if its Strength "
					+ "score is less than or equal to the hand’s Strength score. If its Strength score is higher than the hand’s Strength score, the target can move toward "
					+ "you through the hand’s space, but that space is difficult terrain for the target.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 6th level or higher, the damage from the clenched fist option increases by 2d8 and "
					+ "the damage from the grasping hand increases by 2d6 for each slot level above 5th.";
			setSpell("1 action", "120 feet", "V, S, M (an eggshell and a snakeskin glove", "Concentration, up to 1 minute", 5, false);
			break;
		case "Blade Barrier":
			description = "You create a vertical wall of whirling, razor-sharp blades made of magical energy. The wall appears within range and lasts for the duration. You "
					+ "can make a straight wall up to 100 feet long, 20 feet high, and 5 feet thick, or a ringed wall up to 60 feet in diameter, 20 feet high, and 5 feet "
					+ "thick. The wall provides three-quarters cover to creatures behind it, and its space is difficult terrain.\n"
					+ "When a creature enters the wall’s area for the first time on a turn or starts its turn there, the creature must make a Dexterity saving throw. On a "
					+ "failed save, the creature takes 6 d10 slashing damage. On a successful save, the creature takes half as much damage.";
			setSpell("1 action", "90 feet", "V, S", "Concentration, up to 10 minutes", 6, false);
			break;
		case "Blade Ward":
			description = "You extend your hand and trace a sigil of warding in the air. Until the end of your next turn, you have resistance against bludgeoning, "
					+ "piercing, and slashing damage dealt by weapon attacks.";
			setSpell("1 action", "Self", "V, S", "1 round", 0, false);
			break;
		case "Bless":
			description = "You bless up to three creatures of your choice within range. Whenever a target makes an attack roll or a saving throw before the spell ends, "
					+ "the target can roll a d4 and add the number rolled to the attack roll or saving throw.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level "
					+ "above 1st.";
			setSpell("1 action", "30 feet", "V, S, M (a sprinkling of holy water)", "Concentration, up to 1 minute", 1, false);
			break;
		case "Blight":
			description = "Necromantic energy washes over a creature of your choice that you can see within range, draining moisture and vitality from it. The target must "
					+ "make a Constitution saving throw. The target takes 8d8 necrotic damage on a failed save, or half as much damage on a successful one. This spell has "
					+ "no effect on undead or constructs.\n"
					+ "If you target a plant creature or a magical plant, it makes the saving throw with disadvantage, and the spell deals maximum damage to it.\n"
					+ "If you target a nonmagical plant that isn’t a creature, such as a tree or shrub, it doesn’t make a saving throw; it simply withers and dies.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 5th level or higher, the damage increases by 1d8 for each slot level above 4th.";
			setSpell("1 action", "30 feet", "V, S", "Instantaneous", 4, false);
			break;
		case "Blinding Smite":
			description = "The next time you hit a creature with a melee weapon attack during this spell’s duration, your weapon flares with bright light, and the attack "
					+ "deals an extra 3d8 radiant damage to the target. Additionally, the target must succeed on a Constitution saving throw or be blinded until the spell "
					+ "ends.\n"
					+ "A creature blinded by this spell makes another Constitution saving throw at the end of each of its turns. On a successful save, it is no longer "
					+ "blinded.";
			setSpell("1 bonus action", "Self", "V", "Concentration, up to 1 minute", 3, false);
			break;
		case "Blindness/Deafness":
			description = "You can blind or deafen a foe. Choose one creature that you can see within range to make a Constitution saving throw. If it fails, the target is "
					+ "either blinded or deafened (your choice) for the duration. At the end of each of its turns, the target can make a Constitution saving throw. On a "
					+ "success, the spell ends.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 3rd level or higher, you can target one additional creature for each slot "
					+ "level above 2nd.";
			setSpell("1 action", "30 feet", "V", "1 minute", 2, false);
			break;
		case "Blink":
			description = "Roll a d20 at the end of each of your turns for the duration of the spell. On a roll of 11 or higher, you vanish from your current plane of "
					+ "existence and appear in the Ethereal Plane (the spell fails and the casting is wasted if you were already on that plane). At the start of your next "
					+ "turn, and when the spell ends if you are on the Ethereal Plane, you return to an unoccupied space of your choice that you can see within 10 feet of "
					+ "the space you vanished from. If no unoccupied space is available within that range, you appear in the nearest unoccupied space (chosen at random if "
					+ "more than one space is equally near). You can dismiss this spell as an action.\n"
					+ "While on the Ethereal Plane, you can see and hear the plane you originated from, which is cast in shades of gray, and you can’t see anything there "
					+ "more than 60 feet away. You can only affect and be affected by other creatures on the Ethereal Plane. Creatures that aren’t there can’t perceive you "
					+ "or interact with you, unless they have the ability to do so.";
			setSpell("1 action", "Self", "V, S", "1 minute", 3, false);
			break;
		case "Blur":
			description = "Your body becomes blurred, shifting and wavering to all who can see you. For the duration, any creature has disadvantage on attack rolls against "
					+ "you. An attacker is immune to this effect if it doesn’t rely on sight, as with blindsight, or can see through illusions, as with truesight.";
			setSpell("1 action", "Self", "V", "Concentration, up to 1 minute", 2, false);
			break;
		case "Branding Smite":
			description = "The next time you hit a creature with a weapon attack before this spell ends, the weapon gleams with astral radiance as you strike. "
					+ "The attack deals an extra 2d6 radiant damage to the target, which becomes visible if it’s invisible, and the target sheds dim light in a 5-foot "
					+ "radius and can’t become invisible until the spell ends.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 3rd level or higher, the extra damage increases by 1d6 for each slot level above 2nd.";
			setSpell("1 bonus action", "Self", "V", "Concentration, up to 1 minute", 2, false);
			break;
		case "Burning Hands":
			description = "As you hold your hands with thumbs touching and fingers spread, a thin sheet of flames shoots forth from your outstretched fingertips. "
					+ "Each creature in a 15-foot cone must make a Dexterity saving throw. A creature takes 3d6 fire damage on a failed save, or half as much damage on a "
					+ "successful one.\n"
					+ "The fire ignites any flammable objects in the area that aren’t being worn or carried.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.";
			setSpell("1 action", "Self (15-foot cone)", "V, S", "Instantaneous", 1, false);
			break;
		case "Call Lightning":
			description = "A storm cloud appears in the shape of a cylinder that is 10 feet tall with a 60-foot radius, centered on a point you can see 100 feet directly "
					+ "above you. The spell fails if you can’t see a point in the air where the storm cloud could appear (for example, if you are in a room that can’t "
					+ "accommodate the cloud).\n"
					+ "When you cast the spell, choose a point you can see within range. A bolt of lightning flashes down from the cloud to that point. Each creature "
					+ "within 5 feet of that point must make a Dexterity saving throw. A creature takes 3d10 lightning damage on a failed save, or half as much damage on a "
					+ "successful one. On each of your turns until the spell ends, you can use your action to call down lightning in this way again, targeting the same "
					+ "point or a different one.\n"
					+ "If you are outdoors in stormy conditions when you cast this spell, the spell gives you control over the existing storm instead of creating a new one. "
					+ "Under such conditions, the spell’s damage increases by 1d10.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 4th or higher level, the damage increases by 1d10 for each slot level above 3rd.";
			setSpell("1 action", "120 feet", "V, S", "Concentration, up to 10 minutes", 3, false);
			break;
		case "Calm Emotions":
			description = "You attempt to suppress strong emotions in a group of people. Each humanoid in a 20-foot-radius sphere centered on a point you choose within "
					+ "range must make a Charisma saving throw; a creature can choose to fail this saving throw if it wishes. If a creature fails its saving throw, choose "
					+ "one of the following two effects.\n"
					+ "You can suppress any effect causing a target to be charmed or frightened. When this spell ends, any suppressed effect resumes, provided that its "
					+ "duration has not expired in the meantime.\n"
					+ "Alternatively, you can make a target indifferent about creatures of your choice that it is hostile toward. This indifference ends if the target is "
					+ "attacked or harmed by a spell or if it witnesses any of its friends being harmed. When the spell ends, the creature becomes hostile again, unless "
					+ "the DM rules otherwise.";
			setSpell("1 action", "60 feet", "V, S", "Concentration, up to 1 minute", 2, false);
			break;
		case "Chain Lightning":
			description = "You create a bolt of lightning that arcs toward a target of your choice that you can see within range. Three bolts then leap from that target to "
					+ "as many as three other targets, each of which must be within 30 feet of the first target. A target can be a creature or an object and can be targeted "
					+ "by only one of the bolts.\n"
					+ "A target must make a Dexterity saving throw. The target takes 10d8 lightning damage on a failed save, or half as much damage on a successful one.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 7th level or higher, one additional bolt leaps from the first target to another "
					+ "target for each slot level above 6th.";
			setSpell("1 action", "150 feet", "V, S, M (a bit of fur; a piece of amber, glass, or a crystal rod; and three silver pins)", "Instantaneous", 6, false);
			break;
		case "Charm Person":
			description = "You attempt to charm a humanoid you can see within range. It must make a Wisdom saving throw, and does so with advantage if you or your "
					+ "companions are fighting it. If it fails the saving throw, it is charmed by you until the spell ends or until you or your companions do anything "
					+ "harmful to it. The charmed creature regards you as a friendly acquaintance. When the spell ends, the creature knows it was charmed by you.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level "
					+ "above 1st. The creatures must be within 30 feet of each other when you target them.";
			setSpell("1 action", "30 feet", "V, S", "1 hour", 1, false);
			break;
		case "Chill Touch":
			description = "You create a ghostly, skeletal hand in the space of a "
					+ "creature within range. Make a ranged spell attack "
					+ "against the creature to assail it with the chill of the "
					+ "grave. On a hit, the target takes 1d8 necrotic damage, "
					+ "and it can’t regain hit points until the start of your next "
					+ "turn. Until then, the hand clings to the target.\n"
					+ "If you hit an undead target, it also has disadvantage on "
					+ "attack rolls against you until the end of your next turn.\n"
					+ "This spell’s damage increases by 1d8 when you reach "
					+ "5th level (2d8), 11th level (3d8), and 17th level (4d8).";
			setSpell("1 action", "120 feet", "V, S", "1 round", 0, false);
			break;
		case "Chromatic Orb":
			description = "You hurl a 4-inch-diameter sphere of energy at a "
					+ "creature that you can see within range. You choose "
					+ "acid, cold, fire, lightning, poison, or thunder for the type "
					+ "of orb you create, and then make a ranged spell attack "
					+ "against the target. If the attack hits, the creature takes "
					+ "3d8 damage of the type you chose.\n"
					+ "At Higher Levels. When you cast this spell using a "
					+ "spell slot of 2nd level or higher, the damage increases by "
					+ "1d8 for each slot level above 1st.";
			setSpell("1 action", "90 feet", "V, S, M (a diamond worth at least 50 gp)", "Instantaneous", 1, false);
			break;
		case "Circle of Death":
			description = "A sphere of negative energy ripples out in a 60-footradius "
					+ "sphere from a point within range. Each creature "
					+ "in that area must make a Constitution saving throw. A "
					+ "target takes 8d6 necrotic damage on a failed save, or "
					+ "half as much damage on a successful one.\n"
					+ "At Higher Levels. When you cast this spell using a "
					+ "spell slot of 7th level or higher, the damage increases by "
					+ "2d6 for each slot level above 6th.";
			setSpell("1 action", "150 feet", " V, S, M (the powder of a crushed black pearl worth at least 500 gp)", "Instantaneous", 6, false);
			break;
		case "Circle of Power":
			description = "Divine energy radiates from you, distorting and "
					+ "diffusing magical energy within 30 feet of you. Until "
					+ "the spell ends, the sphere moves with you, centered on "
					+ "you. For the duration, each friendly creature in the area "
					+ "(including you) has advantage on saving throws against "
					+ "spells and other magical effects. Additionally, when "
					+ "an affected creature succeeds on a saving throw made "
					+ "against a spell or magical effect that allows it to make a saving throw to take only half damage, it instead takes "
					+ "no damage if it succeeds on the saving throw.";
			setSpell("1 action", "Self (30-foot radius)", "V", "Concentration, up to 10 minutes", 5, false);
			break;
		case "Clairvoyance":
			description = "You create an invisible sensor within range in a location familiar to you (a place you have visited or seen before) "
					+ "or in an obvious location that is unfamiliar to you (such as behind a door, around a corner, or in a grove of trees). "
					+ "The sensor rem ains in place for the duration, and it can’t be attacked or otherwise interacted with.\n"
					+ "When you cast the spell, you choose seeing or hearing. You can use the chosen sense through the "
					+ "sensor as if you were in its space. As your action, you can switch between seeing and hearing.\n"
					+ "A creature that can see the sensor (such as a creature benefiting from see invisibility or truesight) sees a "
					+ "luminous, intangible orb about the size of your fist";
			setSpell("10 minutes",  "1 mile", "V, S, M (a focus worth at least 100 gp, either a jeweled horn for hearing or a glass eye for seeing)", 
					"Concentration, up to 10 minutes", 3, false);
			break;
		case "Clone":
			description = "This spell grows an inert duplicate of a living creature as a safeguard against death. This clone forms inside "
					+ "a sealed vessel and grows to full size and maturity after 120 days; you can also choose to have the clone "
					+ "be a younger version of the same creature. It remains inert and endures indefinitely, as long as its vessel "
					+ "rem ains undisturbed.\n"
					+ "At any time after the clone matures, if the original creature dies, its soul transfers to the clone, provided "
					+ "that the soul is free and willing to return. The clone is physically identical to the original and has the same "
					+ "personality, memories, and abilities, but none of the original’s equipment. The original creature’s physical "
					+ "remains, if they still exist, become inert and can’t thereafter be restored to life, since the creature’s soul "
					+ "is elsewhere.";
			setSpell("1 hour", "Touch", "V, S, M (a diamond worth at least 1,000 gp and at least 1 cubic inch of flesh of the creature "
					+ "that is to be cloned, which the spell consumes, and a vessel worth at least 2,000 gp that has a sealable lid "
					+ "and is large enough to hold a Medium creature, such as a huge urn, coffin, mud-filled cyst in the ground, or "
					+ "crystal container filled with salt water)", "Instantaneous", 8, false);
			break;
		case "Cloud of Daggers":
			description = "You fill the air with spinning daggers in a cube 5 feet on each side, centered on a point you choose within range. "
					+ "A creature takes 4d4 slashing damage when it enters the spell’s area for the first time on a turn or starts its turn there.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 3rd level or higher, the damage increases by 2d4 for each slot level above 2nd.";
			setSpell("1 action", "60 feet", "V, S, M (a sliver of glass)", "Concentration, up to 1 minute", 2, false);
			break;
		case "Cloudkill":
			description = "You create a 20-foot-radius sphere of poisonous, yellow-green fog centered on a point you choose within range. "
					+ "The fog spreads around corners. It lasts for the duration or until strong wind disperses the fog, ending the spell. "
					+ "Its area is heavily obscured.\n"
					+ "When a creature enters the spell’s area for the first time on a turn or starts its turn there, that creature must "
					+ "make a Constitution saving throw. The creature takes 5d8 poison damage on a failed save, or half as much "
					+ "damage on a successful one. Creatures are affected even if they hold their breath or don’t need to breathe.\n"
					+ "The fog moves 10 feet away from you at the start of each of your turns, rolling along the surface of the "
					+ "ground. The vapors, being heavier than air, sink to the lowest level of the land, even pouring down openings.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 6th level or higher, the damage increases by 1d8 for each slot level above 5th.";
			setSpell("1 action", "120 feet", "V, S", "Concentration, up to 10 minutes", 5, false);
			break;
		case "Color Spray":
			description = "A dazzling array of flashing, colored light springs from your hand. Roll 6 d10; the total is how many hit points "
					+ "of creatures this spell can effect. Creatures in a 15-foot cone originating from you are affected in ascending "
					+ "order of their current hit points (ignoring unconscious creatures and creatures that can’t see).\n"
					+ "Starting with the creature that has the lowest current hit points, each creature affected by this spell is blinded "
					+ "until the spell ends. Subtract each creature’s hit points from the total before moving on to the creature with "
					+ "the next lowest hit points. A creature’s hit points must be equal to or less than the remaining total for that "
					+ "creature to be affected.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, roll an additional 2d10 for each slot level above 1st.";
			setSpell("1 action", "Self (15-foot cone)", "V, S, M (a pinch of powder or sand that is colored red, yellow, and blue)", "1 round", 1, false);
			break;
		case "Command":
			description = "You speak a one-word command to a creature you can see within range. The target must succeed on a Wisdom "
					+ "saving throw or follow the command on its next turn. The spell has no effect if the target is undead, if it "
					+ "doesn’t understand your language, or if your command is directly harmful to it.\n"
					+ "Some typical commands and their effects follow. You might issue a command other than one described here. "
					+ "If you do so, the DM determines how the target behaves. If the target can’t follow your command, the spell ends.\n"
					+ "Approach. The target moves toward you by the shortest and most direct route, ending its turn if it moves within 5 feet of you.\n"
					+ "Drop. The target drops whatever it is holding and then ends its turn.\n"
					+ "Flee. The target spends its turn moving away from you by the fastest available means.\n"
					+ "Grovel. The target falls prone and then ends its turn.\n"
					+ "Halt. The target doesn’t move and takes no actions. A flying creature stays aloft, provided that it is able to "
					+ "do so. If it must move to stay aloft, it flies the minimum distance needed to remain in the air.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, you can affect one "
					+ "additional creature for each slot level above 1st. The creatures must be within 30 feet of each other when you target them.";
			setSpell("1 action", "60 feet", "V", "1 round", 1, false);
			break;
		case "Commune":
			description = "You contact your deity or a divine proxy and ask up to three questions that can be answered with a yes or no. "
					+ "You must ask your questions before the spell ends. You receive a correct answer for each question.\n"
					+ "Divine beings aren’t necessarily omniscient, so you might receive “unclear” as an answer if a question "
					+ "pertains to information that lies beyond the deity’s knowledge. In a case where a one-word answer could be "
					+ "misleading or contrary to the deity’s interests, the DM might offer a short phrase as an answer instead.\n"
					+ "If you cast the spell two or more times before finishing your next long rest, there is a cumulative 25 percent "
					+ "chance for each casting after the first that you get no answer. The DM makes this roll in secret.";
			setSpell("1 minute", "Self", "V, S, M (incense and a vial of holy or unholy water)", "1 minute", 5, true);
			break;
		case "Commune with Nature":
			description = "You briefly become one with nature and gain knowledge of the surrounding territory. In the outdoors, the spell "
					+ "gives you knowledge of the land within 3 miles of you. In caves and other natural underground settings, the "
					+ "radius is limited to 300 feet. The spell doesn’t function where nature has been replaced by construction, such as in dungeons and towns.\n"
					+ "You instantly gain knowledge of up to three facts of your choice about any of the following subjects as they relate to the area:\n"
					+ "- terrain and bodies of water\n"
					+ "- prevalent plants, minerals, animals, or peoples\n"
					+ "- powerful celestials, fey, fiends, elementals, or undead\n"
					+ "- influence from other planes of existence\n"
					+ "- buildings\n"
					+ "For example, you could determine the location of powerful undead in the area, the location of major "
					+ "sources of safe drinking water, and the location of any nearby towns.";
			setSpell("1 minute", "Self", "V, S", "Instantaneous", 5, true);
			break;
		case "Compelled Duel":
			description = "You attempt to compel a creature into a duel. One creature that you can see within range must make a "
					+ "Wisdom saving throw. On a failed save, the creature is drawn to you, compelled by your divine demand. For "
					+ "the duration, it has disadvantage on attack rolls against creatures other than you, and must make a Wisdom "
					+ "saving throw each time it attempts to m ove to a space that is more than 30 feet away from you; if it succeeds "
					+ "on this saving throw, this spell doesn’t restrict the target’s movement for that turn.\n"
					+ "The spell ends if you attack any other creature, if you cast a spell that targets a hostile creature other than the "
					+ "target, if a creature friendly to you damages the target or casts a harmful spell on it, or if you end your turn more "
					+ "than 30 feet away from the target.";
			setSpell("1 bonus action", "30 feet", "V", "Concentration, up to 1 minute", 1, false);
			break;
		case "Comprehend Languages":
			description = "For the duration, you understand the literal meaning of any spoken language that you hear. You also understand "
					+ "any written language that you see, but you must be touching the surface on which the words are written. It "
					+ "takes about 1 minute to read one page of text.\nThis spell doesn’t decode secret messages in a text "
					+ "or a glyph, such as an arcane sigil, that isn’t part of a written language.";
			setSpell("1 action", "Self", "V, S, M (a pinch of soot and salt)", "1 hour", 1, true);
			break;
		case "Compulsion":
			description = "Creatures of your choice that you can see within range and that can hear you must make a Wisdom saving "
					+ "throw. A target automatically succeeds on this saving throw if it can’t be charmed. On a failed save, a target "
					+ "is affected by this spell. Until the spell ends, you can use a bonus action on each of your turns to designate a "
					+ "direction that is horizontal to you. Each affected target must use as much of its movement as possible to move "
					+ "in that direction on its next turn. It can take its action before it moves. After moving in this way, it can make "
					+ "another Wisdom saving to try to end the effect.\n"
					+ "A target isn’t com pelled to move into an obviously deadly hazard, such as a fire or pit, but it will provoke "
					+ "opportunity attacks to move in the designated direction.";
			setSpell("1 action", "30 feet", "V, S", "Concentration, up to 1 minute", 4, false);
			break;
		case "Cone of Cold":
			description = "A blast of cold air erupts from your hands. Each creature in a 60-foot cone must make a Constitution "
					+ "saving throw. A creature takes 8d8 cold damage on a failed save, or half as much damage on a successful one. "
					+ "A creature killed by this spell becomes a frozen statue until it thaws.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 6th level or higher, the damage increases by 1d8 for each slot level above 5th.";
			setSpell("1 action", "Self (60-foot cone)", "V, S, M (a small crystal or glass cone)", "Instantaneous", 5, false);
			break;
		case "Confusion":
			description = "This spell assaults and twists creatures' minds, spawning delusions and provoking uncontrolled action. "
					+ "Each creature in a 10-foot-radius sphere centered on a point you choose within range must succeed on a "
					+ "Wisdom saving throw when you cast this spell or be affected by it.\n"
					+ "An affected target can’t take reactions and must roll a d10 at the start of each of its turns to determine its behavior for that turn.\n"
					+ "1 The creature uses all its movement to move in a random direction. To determine the direction, roll "
					+ "a d8 and assign a direction to each die face. The creature doesn’t take an action this turn.\n"
					+ "2-6 The creature doesn’t move or take actions this turn.\n"
					+ "7-8 The creature uses its action to make a melee attack against a randomly determined creature within its "
					+ "reach. If there is no creature within its reach, the creature does nothing this turn.\n"
					+ "9-10 The creature can act and move normally.\n"
					+ "At the end of each of its turns, an affected target can make a Wisdom saving throw. If it succeeds, this effect ends for that target.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 5th level or higher, the radius of the sphere "
					+ "increases by 5 feet for each slot level above 4th.";
			setSpell("1 action", "90 feet", "V, S, M (three nut shells)", "Concentration, up to 1 minute", 4, false);
			break;
		case "Conjure Animals":
			description = "You summon fey spirits that take the form of beasts and appear in unoccupied spaces that you can see within "
					+ "range. Choose one of the following options for what appears:\n"
					+ "- One beast of challenge rating 2 or lower\n"
					+ "- Two beasts of challenge rating 1 or lower\n"
					+ "- Four beasts of challenge rating 1/2 or lower\n"
					+ "- Eight beasts of challenge rating 1/4 or lower\n"
					+ "Each beast is also considered fey, and it disappears when it drops to 0 hit points or when the spell ends. "
					+ "The summoned creatures are friendly to you and your companions. Roll initiative for the summoned creatures "
					+ "as a group, which has its own turns. They obey any verbal commands that you issue to them (no action "
					+ "required by you). If you don’t issue any commands to them, they defend themselves from hostile creatures, "
					+ "but otherwise take no actions.\n"
					+ "The DM has the creatures’ statistics.\n"
					+ "At Higher Levels. When you cast this spell using certain higher-level spell slots, you choose one of the "
					+ "summoning options above, and more creatures appear: twice as many with a 5th-level slot, three times as many "
					+ "with a 7th-level slot, and four times as many with a 9th-level slot.";
			setSpell("1 action", "60 feet", "V, S", "Concentration, up to 1 hour", 3, false);
			break;
		case "Conjure Barrage":
			description = "You throw a nonmagical weapon or fire a piece of nonmagical ammunition into the air to create a cone "
					+ "of identical weapons that shoot forward and then disappear. Each creature in a 60-foot cone must succeed "
					+ "on a Dexterity saving throw. A creature takes 3d8 damage on a failed save, or half as much damage on a "
					+ "successful one. The damage type is the same as that of the weapon or ammunition used as a component.";
			setSpell("1 action", "Self (60-foot bone)", "V, S, M (one piece of ammunition or a thrown weapon)", "Instantaneous", 3, false);
			break;
		case "Conjure Celestial":
			description = "You summon a celestial of challenge rating 4 or lower, which appears in an unoccupied space that you can see "
					+ "within range. The celestial disappears when it drops to 0 hit points or when the spell ends.\n"
					+ "The celestial is friendly to you and your companions for the duration. Roll initiative for the celestial, which "
					+ "has its own turns. It obeys any verbal commands that you issue to it (no action required by you), as long as "
					+ "they don’t violate its alignment. If you don’t issue any commands to the celestial, it defends itself from hostile "
					+ "creatures but otherwise takes no actions.\n"
					+ "The DM has the celestial’s statistics.\n"
					+ "At Higher Levels. When you cast this spell using a 9th-level spell slot, you summon a celestial of challenge rating 5 or lower.";
			setSpell("1 minute", "90 feet", "V, S", "Concentration, up to 1 hour", 7, false);
			break;
		case "Conjure Elemental":
			description = "You call forth an elemental servant. Choose an area of air, earth, fire, or water that fills a 10-foot cube within range. "
					+ "An elemental of challenge rating 5 or lower appropriate to the area you chose appears in an unoccupied space "
					+ "within 10 feet of it. For example, a fire elemental emerges from a bonfire, and an earth elemental rises "
					+ "up from the ground. The elemental disappears when it drops to 0 hit points or when the spell ends.\n"
					+ "The elemental is friendly to you and your companions for the duration. Roll initiative for the elemental, which "
					+ "has its own turns. It obeys any verbal commands that you issue to it (no action required by you). If you don’t "
					+ "issue any commands to the elemental, it defends itself from hostile creatures but otherwise takes no actions.\n"
					+ "If your concentration is broken, the elemental doesn’t disappear. Instead, you lose control of the elemental, "
					+ "it becomes hostile toward you and your companions, and it might attack. An uncontrolled elemental can’t "
					+ "be dismissed by you, and it disappears 1 hour after you summoned it.\n"
					+ "The DM has the elemental’s statistics.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 6th level or higher, the challenge rating "
					+ "increases by 1 for each slot level above 5th.";
			setSpell("1 minute", "90 feet", " V, S, M (burning incense for air, soft clay for earth, sulfur and phosphorus for fire, or water and sand for water)", 
					"Concentration, up to 1 hour", 5, false);
			break;
		case "Conjure Fey":
			description = "You summon a fey creature of challenge rating 6 or lower, or a fey spirit that takes the form of a beast of "
					+ "challenge rating 6 or lower. It appears in an unoccupied space that you can see within range. The fey creature "
					+ "disappears when it drops to 0 hit points or when the spell ends.\n"
					+ "The fey creature is friendly to you and your companions for the duration. Roll initiative for the "
					+ "creature, which has its own turns. It obeys any verbal commands that you issue to it (no action required "
					+ "by you), as long as they don't violate its alignment. If you don’t issue any commands to the fey creature, it "
					+ "defends itself from hostile creatures but otherwise takes no actions.\n"
					+ "If your concentration is broken, the fey creature doesn’t disappear. Instead, you lose control of the "
					+ "fey creature, it becomes hostile toward you and your companions, and it might attack. An uncontrolled fey "
					+ "creature can't be dismissed by you, and it disappears 1 hour after you summoned it.\n"
					+ "The DM has the fey creature’s statistics.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 7th level or higher, the challenge rating "
					+ "increases by 1 for each slot level above 6th.";
			setSpell("1 minute", "90 feet", "V, S", "Concentration, up to 1 hour", 6, false);
			break;
		case "Conjure Minor Elementals":
			description = "You summon elementals that appear in unoccupied spaces that you can see within range. You choose one "
					+ "the following options for what appears:\n"
					+ "- One elemental of challenge rating 2 or lower\n"
					+ "- Two elementals of challenge rating 1 or lower\n"
					+ "- Four elementals of challenge rating 1/2 or lower\n"
					+ "- Eight elementals of challenge rating 1/4 or lower.\n"
					+ "An elemental summoned by this spell disappears when it drops to 0 hit points or when the spell ends.\n"
					+ "The summoned creatures are friendly to you and your companions. Roll initiative for the summoned creatures "
					+ "as a group, which has its own turns. They obey any commands that you issue to them (no action "
					+ "required by you). If you don’t issue any commands to them, they defend themselves from hostile creatures, but otherwise take no actions.\n"
					+ "The DM has the creatures' statistics.\n"
					+ "At Higher Levels. When you cast this spell using certain higher-level spell slots, you choose one of the "
					+ "summoning options above, and more creatures appear: twice as many with a 6th-level slot and three times as many with an 8th-level slot.";
			setSpell("1 minute", "90 feet", "V, S", "Concentration, up to 1 hour", 4, false);
			break;
		case "Conjure Volley":
			description = "You fire a piece of nonmagical ammunition from a ranged weapon or throw a nonmagical weapon into "
					+ "the air and choose a point within range. Hundreds of duplicates of the ammunition or weapon fall in a volley "
					+ "from above and then disappear. Each creature in a 40-foot-radius. 20-foot-high cylinder centered on that "
					+ "point must make a Dexterity saving throw. A creature takes 8d8 damage on a failed save, or half as much "
					+ "damage on a successful one. The damage type is the same as that of the ammunition or weapon.";
			setSpell("1 action", "150 feet", "V, S, M (one piece of ammunition or one thrown weapon)", "Instantaneous", 5, false);
			break;
		case "Conjure Woodland Beings":
			description = "You summon fey creatures that appear in unoccupied spaces that you can see within range. Choose one of the following options for what appears:\n"
					+ "- One fey creature of challenge rating 2 or lower\n"
					+ "- Two fey creatures of challenge rating 1 or lower\n"
					+ "- Four fey creatures of challenge rating 1/2 or lower\n"
					+ "- Eight fey creatures of challenge rating 1/4 or lower\n"
					+ "A summoned creature disappears when it drops to 0 hit points or when the spell ends.\n"
					+ "The summoned creatures are friendly to you and your companions. Roll initiative for the summoned creatures "
					+ "as a group, which have their own turns. They obey any verbal commands that you issue to them (no action "
					+ "required by you). If you don't issue any commands to them, they defend themselves from hostile creatures, "
					+ "but otherwise take no actions.\n"
					+ "The DM has the creatures’ statistics.\n"
					+ "At Higher Levels. When you cast this spell using certain higher-level spell slots, you choose one of the "
					+ "summoning options above, and more creatures appear: twice as many with a 6th-level slot and three times as many with an 8th-level slot.";
			setSpell("1 action", "60 feet", "V, S, M (one holly berry per creature summoned)", "Concentration, up to 1 hour", 4, false);
			break;
		case "Contact Other Plane":
			description = "You mentally contact a demigod, the spirit of a long-dead sage, or some other mysterious entity from another "
					+ "plane. Contacting this extraplanar intelligence can strain or even break your mind. When you cast this "
					+ "spell, make a DC 15 Intelligence saving throw. On a failure, you take 6d6 psychic damage and are insane "
					+ "until you finish a long rest. While insane, you can’t take actions, can’t understand what other creatures say, can’t "
					+ "read, and speak only in gibberish. A greater restoration spell cast on you ends this effect.\n"
					+ "On a successful save, you can ask the entity up to five questions. You must ask your questions before the spell "
					+ "ends. The DM answers each question with one word, such as “yes,” “no,” “maybe,” “never,” “irrelevant,” or "
					+ "“unclear” (if the entity doesn’t know the answer to the question). If a one-word answer would be misleading, "
					+ "the DM might instead offer a short phrase as an answer.";
			setSpell("1 minute", "Self", "V", "1 minute", 5, true);
			break;
		case "Contagion":
			description = "Your touch inflicts disease. Make a melee spell attack against a creature within your reach. On a hit, you afflict "
					+ "the creature with a disease of your choice from any of the ones described below.\n"
					+ "At the end of each of the target’s turns, it must make a Constitution saving throw. After failing three of "
					+ "these saving throws, the disease’s effects last for the duration, and the creature stops making these saves. "
					+ "After succeeding on three of these saving throws, the creature recovers from the disease, and the spell ends.\n"
					+ "Since this spell induces a natural disease in its target, any effect that removes a disease or otherwise "
					+ "ameliorates a disease’s effects apply to it.\n"
					+ "Blinding Sickness. Pain grips the creature’s mind, and its eyes turn milky white. The creature has "
					+ "disadvantage on Wisdom checks and Wisdom saving throws and is blinded.\n"
					+ "Filth Fever. A raging fever sweeps through the creature’s body. The creature has disadvantage on "
					+ "Strength checks, Strength saving throws, and attack rolls that use Strength.\n"
					+ "Flesh Rot. The creature’s flesh decays. The creature has disadvantage on Charisma checks and vulnerability to all damage.\n"
					+ "Mindfire. The creature’s mind becomes feverish. The creature has disadvantage on Intelligence checks and "
					+ "Intelligence saving throws, and the creature behaves as if under the effects of the confusion spell during combat.\n"
					+ "Seizure. The creature is overcome with shaking. The creature has disadvantage on Dexterity checks, "
					+ "Dexterity saving throws, and attack rolls that use Dexterity.\n"
					+ "Slimy Doom. The creature begins to bleed uncontrollably. The creature has disadvantage on "
					+ "Constitution checks and Constitution saving throws. In addition, whenever the creature takes damage, it is stunned until the end of its next turn.";
			setSpell("1 action", "Touch", "V, S", "7 days", 5, false);
			break;
		case "Contingency":
			description = "Choose a spell of 5th level or lower that you can cast, that has a casting time of 1 action, and that can target you. "
					+ "You cast that spell—called the contingent spell—as part of casting contingency, expending spell slots for both, but "
					+ "the contingent spell doesn't come into effect. Instead, it takes effect when a certain circumstance occurs. You "
					+ "describe that circumstance when you cast the two spells. For example, a contingency cast with water breathing "
					+ "might stipulate that water breathing comes into effect when you are engulfed in water or a similar liquid.\n"
					+ "The contingent spell takes effect immediately after the circumstance is met for the first time, whether or not you "
					+ "want it to. and then contingency ends.\n"
					+ "The contingent spell takes effect only on you, even if it can normally target others. You can use only one "
					+ "contingency spell at a time. If you cast this spell again, the effect of another contingency spell on you ends. Also, "
					+ "contingency ends on you if its material component is ever not on your person.";
			setSpell("10 minutes", "Self", "V, S, M (a statuette of yourself carved from ivory and decorated with gems worth a least 1,500 gp)", "10 days", 6, false);
			break;
		case "Continual Flame":
			description = "A flame, equivalent in brightness to a torch, springs forth from an object that you touch. The effect looks like"
					+ "a regular flame, but it creates no heat and doesn’t use oxygen. A continual flame can be covered or hidden but not smothered or quenched.";
			setSpell("1 action", "Touch", "V, S, M (ruby dust worth 50 gp, which the spell consumes)", "Until dispelled", 2, false);
			break;
		case "Control Water":
			description = "Until the spell ends, you control any freestanding water inside an area you choose that is a cube up to 100 feet "
					+ "on a side. You can choose from any of the following effects when you cast this spell. As an action on your "
					+ "turn, you can repeat the sam e effect or choose a different one.\n"
					+ "Flood. You cause the water level of all standing water in the area to rise by as much as 20 feet. If the area includes "
					+ "a shore, the flooding water spills over onto dry land.\n"
					+ "If you choose an area in a large body of water, you instead create a 20-foot tall wave that travels from one "
					+ "side of the area to the other and then crashes down. Any Huge or smaller vehicles in the wave’s path are carried "
					+ "with it to the other side. Any Huge or smaller vehicles struck by the wave have a 25 percent chance of capsizing.\n"
					+ "The water level remains elevated until the spell ends or you choose a different effect. If this effect produced "
					+ "a wave, the wave repeats on the start of your next turn while the flood effect lasts.\n"
					+ "Part Water. You cause water in the area to move apart and create a trench. The trench extends across "
					+ "the spell’s area, and the separated water forms a wall to either side. The trench remains until the spell ends or "
					+ "you choose a different effect. The water then slowly fills in the trench over the course of the next round until the normal water level is restored.\n"
					+ "Redirect Flow. You cause flowing water in the area to move in a direction you choose, even if the water has "
					+ "to flow over obstacles, up walls, or in other unlikely directions. The water in the area m oves as you direct "
					+ "it, but once it moves beyond the spell’s area, it resumes its flow based on the terrain conditions. The water "
					+ "continues to move in the direction you chose until the spell ends or you choose a different effect.\n"
					+ "Whirlpool. This effect requires a body of water at least 50 feet square and 25 feet deep. You cause "
					+ "a whirlpool to form in the center of the area. The whirlpool forms a vortex that is 5 feet wide at the "
					+ "base, up to 50 feet wide at the top, and 25 feet tall. Any creature or object in the water and within 25 feet of the "
					+ "vortex is pulled 10 feet toward it. A creature can swim away from the vortex by making a Strength (Athletics) "
					+ "check against your spell save DC.\n"
					+ "When a creature enters the vortex for the first time on a turn or starts its turn there, it must make a Strength "
					+ "saving throw. On a failed save, the creature takes 2d8 bludgeoning damage and is caught in the vortex until "
					+ "the spell ends. On a successful save, the creature takes half damage, and isn’t caught in the vortex. A creature "
					+ "caught in the vortex can use its action to try to swim away from the vortex as described above, but has "
					+ "disadvantage on the Strength (Athletics) check to do so.\n"
					+ "The first time each turn that an object enters the vortex, the object takes 2d8 bludgeoning damage; this "
					+ "damage occurs each round it remains in the vortex.";
			setSpell("1 action", "300 feet", "V, S, M (a drop of water and a pinch of dust)", "Concentration, up to 10 minutes", 4, false);
			break;
		case "Control Weather":
			description = "You take control of the weather within 5 miles of you for the duration. You must be outdoors to cast this spell. "
					+ "Moving to a place where you don’t have a clear path to the sky ends the spell early.\n"
					+ "When you cast the spell, you change the current weather conditions, which are determined by the DM "
					+ "based on the climate and season. You can change precipitation, temperature, and wind. It takes 1d4 x 10 "
					+ "minutes for the new conditions to take effect. Once they do so, you can change the conditions again. When the "
					+ "spell ends, the weather gradually returns to normal.\n"
					+ "When you change the weather conditions, find a current condition on the following tables and change its "
					+ "stage by one, up or down. When changing the wind, you can change its direction.\n"
					+ "Precipitation\n"
					+ "Stage Condition\n"
					+ "1     Clear\n"
					+ "2     Light clouds\n"
					+ "3     Overcast or ground fog\n"
					+ "4     Rain, hail, or snow\n"
					+ "5     Torrential rain, driving hail, or blizzard\n"
					+ "Temperature\n"
					+ "Stage Condition\n"
					+ "1     Unbearable heat\n"
					+ "2     Hot\n"
					+ "3     Warm\n"
					+ "4     Cool\n"
					+ "5     Cold\n"
					+ "6     Arctic cold\n"
					+ "Wind\n"
					+ "Stage Condition\n"
					+ "1     Calm\n"
					+ "2     Moderate wind\n"
					+ "3     Strong wind\n"
					+ "4     Gale\n"
					+ "5 Storm";
			setSpell("10 minutes", "Self (5-mile radius)", "V, S, M (burning incense and bits of earth and wood mixed in water", "Concentration, up to 8 hours", 8, false);
			break;
		case "Cordon of Arrows":
			description = "You plant four pieces of nonmagical ammunition — arrows or crossbow bolts — in the ground within range "
					+ "and lay magic upon them to protect an area. Until the spell ends, whenever a creature other than you comes "
					+ "within 30 feet of the ammunition for the first time on a turn or ends its turn there, one piece of ammunition flies "
					+ "up to strike it. The creature must succeed on a Dexterity saving throw or take 1d6 piercing damage. The piece of "
					+ "ammunition is then destroyed. The spell ends when no ammunition remains.\n"
					+ "When you cast this spell, you can designate any creatures you choose, and the spell ignores them.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 3rd level or higher, the amount of "
					+ "ammunition that can be affected increases by two for each slot level above 2nd.";
			setSpell("1 action", "5 feet", "V, S, M (four or more arrows or bolts)", "8 hours", 2, false);
			break;
		case "Counterspell":
			description = "You attempt to interrupt a creature in the process of casting a spell. If the creature is casting a spell of 3rd "
					+ "level or lower, its spell fails and has no effect. If it is casting a spell of 4th level or higher, make an ability "
					+ "check using your spellcasting ability. The DC equals 10 + the spell’s level. On a success, the creature’s spell fails and has no effect.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 4th level or higher, the interrupted spell has "
					+ "no effect if its level is less than or equal to the level of the spell slot you used.";
			setSpell("1 reaction, which you take when you see a creature within 60 feet of you casting a spell", "60 feet", "S", "Instantaneous", 3, false);
			break;
		case "Create Food and Water":
			description = "You create 45 pounds of food and 30 gallons of water on the ground or in containers within range, enough "
					+ "to sustain up to fifteen humanoids or five steeds for 24 hours. The food is bland but nourishing, and spoils "
					+ "if uneaten after 24 hours. The water is clean and doesn’t go bad.";
			setSpell("1 action", "30 feet", "V, S", "Instantaneous", 3, false);
			break;
		case "Create or Destroy Water":
			description = "You either create or destroy water.\n"
					+ "Create Water. You create up to 10 gallons of clean water within range in an open container. Alternatively, "
					+ "the water falls as rain in a 30-foot cube within range, extinguishing exposed flames in the area.\n"
					+ "Destroy Water. You destroy up to 10 gallons of water in an open container within range. Alternatively, you "
					+ "destroy fog in a 30-foot cube within range.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, you create or destroy "
					+ "10 additional gallons of water, or the size of the cube increases by 5 feet, for each slot level above 1st.";
			setSpell("1 action", "30 feet", "V, S, M (a drop of water if creating water or a few grains of sand if destroying it)", "Instantaneous", 1, false);
			break;
		case "Create Undead":
			description = "You can cast this spell only at night. Choose up to three corpses of Medium or Small hum anoids within range. "
					+ "Each corpse becomes a ghoul under your control. (The DM has game statistics for these creatures.)\n"
					+ "As a bonus action on each of your turns, you can mentally command any creature you animated with "
					+ "this spell if the creature is within 120 feet of you (if you control multiple creatures, you can command any or all "
					+ "of them at the same time, issuing the same command to each one). You decide what action the creature will take "
					+ "and where it will move during its next turn, or you can issue a general command, such as to guard a particular "
					+ "chamber or corridor. If you issue no commands, the creature only defends itself against hostile creatures. "
					+ "Once given an order, the creature continues to follow it until its task is complete.\n"
					+ "The creature is under your control for 24 hours, after which it stops obeying any command you have "
					+ "given it. To maintain control of the creature for another 24 hours, you must cast this spell on the creature "
					+ "before the current 24-hour period ends. This use of the spell reasserts your control over up to three "
					+ "creatures you have animated with this spell, rather than animating new ones.\n"
					+ "At Higher Levels. When you cast this spell using a 7th-level spell slot, you can animate or reassert control "
					+ "over four ghouls. When you cast this spell using an 8th-level spell slot, you can animate or reassert control "
					+ "over five ghouls or two ghasts or wights. When you cast this spell using a 9th-level spell slot, you can animate or "
					+ "reassert control over six ghouls, three ghasts or wights, or two mummies.";
			setSpell("1 minute", "10 feet", "V, S, M (one clay pot filled with grave dirt, one clay pot filled with brackish water, and one 150 gp black onyx stone for"
					+ " each corpse)", "Instantaneous", 6, false);
			break;
		case "Creation":
			description = "You pull wisps of shadow material from the Shadowfell to create a nonliving object of vegetable matter within"
					+ "range: soft goods, rope, wood, or something similar. You can also use this spell to create mineral objects such as"
					+ "stone, crystal, or metal. The object created must be no larger than a 5-foot cube, and the object must be of a"
					+ "form and material that you have seen before.\n"
					+ "The duration depends on the object’s material. If the object is composed of multiple materials, use the shortest duration.\n"
					+ "Materials:\n"
					+ "Vegetable matter: 1 day\n"
					+ "Stone or crystal: 12 hours\n"
					+ "Precious metals: 1 hour\n"
					+ "Gems: 10 minutes\n"
					+ "Adamantine or mithral: 1 minute\n"
					+ "Using any material created by this spell as another spell’s material component causes that spell to fail.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 6th level or higher, the cube increases by 5 feet for each slot level above 5th.";
			setSpell("1 minute", "30 feet", "V, S, M (a tiny piece of matter of the same type of the item you plan to create)", "Special", 5, false);
			break;
		case "Crown of Madness":
			description = "One humanoid of your choice that you can see within range must succeed on a Wisdom saving throw or "
					+ "become charm ed by you for the duration. While the target is charmed in this way, a twisted crown "
					+ "of jagged iron appears on its head, and a madness glows in its eyes.\n"
					+ "The charmed target must use its action before moving on each of its turns to make a melee attack against a "
					+ "creature other than itself that you mentally choose. The target can act normally on its turn if you choose no "
					+ "creature or if none are within its reach.\nOn your subsequent turns, you must use your action to "
					+ "maintain control over the target, or the spell ends. Also, the target can make a Wisdom saving throw at the end "
					+ "of each of its turns. On a success, the spell ends.";
			setSpell("1 action", "120 feet", "V, S", "Concentration, up to 1 minute", 2, false);
			break;
		case "Crusader's Mantle":
			description = "Holy power radiates from you in an aura with a 30-foot radius, awakening boldness in friendly creatures. Until "
					+ "the spell ends, the aura moves with you, centered on you. While in the aura, each nonhostile creature in the "
					+ "aura (including you) deals an extra 1d4 radiant damage when it hits with a weapon attack.";
			setSpell("1 action", "Self", "V", "Concentration, up to 1 minute", 3, false);
			break;
		case "Cure Wounds":
			description = "A creature you touch regains a number of hit points equal to 1d8 + your spellcasting ability modifier. This "
					+ "spell has no effect on undead or constructs.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the healing increases by 1d8 for each slot level above 1st.";
			setSpell("1 action", "Touch", "V, S", "Instantaneous", 1, false);
			break;
		case "Dancing Lights":
			description = "You create up to four torch-sized lights within range, making them appear as torches, lanterns, or glowing "
					+ "orbs that hover in the air for the duration. You can also combine the four lights into one glowing vaguely "
					+ "humanoid form of Medium size. Whichever form you choose, each light sheds dim light in a 10-foot radius.\n"
					+ "As a bonus action on your turn, you can move the lights up to 60 feet to a new spot within range. A light "
					+ "must be within 20 feet of another light created by this spell, and a light w inks out if it exceeds the spell’s range.";
			setSpell("1 action", "120 feet", "V, S, M (a bit of phosphorus or wychwood, or a glowworm)", "Concentration, up to 1 minute", 0, false);
			break;
		case "Darkness":
			description = "Magical darkness spreads from a point you choose within range to fill a 15-foot-radius sphere for the "
					+ "duration. The darkness spreads around corners. A creature with darkvision can’t see through this "
					+ "darkness, and nonmagical light can’t illuminate it.\n"
					+ "If the point you choose is on an object you are holding or one that isn’t being worn or carried, the darkness "
					+ "emanates from the object and moves with it. Completely covering the source of the darkness with an opaque "
					+ "object, such as a bowl or a helm, blocks the darkness.\n"
					+ "If any of this spell’s area overlaps with an area of light created by a spell of 2nd level or lower, the spell that created the light is dispelled.";
			setSpell("1 action", "60 feet", "V, M (bat fur and a drop of pitch or piece of coal)", "Concentration, up to 10 minutes", 2, false);
			break;
		case "Darkvision":
			description = "You touch a willing creature to grant it the ability to see in the dark. For the duration, that creature has darkvision out to a range of 60 feet.";
			setSpell("1 action", "Touch", "V, S, M (either a pinch of dried carrot or an agate)", "8 hours", 2, false);
			break;
		case "Daylight":
			description = "A 60-foot-radius sphere of light spreads out from a point you choose within range. The sphere is bright light and "
					+ "sheds dim light for an additional 60 feet.\n"
					+ "If you chose a point on an object you are holding or one that isn’t being worn or carried, the light shines "
					+ "from the object and moves with it. Completely covering the affected object with an opaque object, such as a bowl or a helm, blocks the light.\n"
					+ "If any of this spell’s area overlaps with an area of darkness created by a spell of 3rd level or lower, the "
					+ "spell that created the darkness is dispelled.";
			setSpell("1 action", "60 feet", "V, S", "1 hour", 3, false);
			break;
		case "Death Ward":
			description = "You touch a creature and grant it a measure of protection from death.\n"
					+ "The first time the target would drop to 0 hit points as a result of taking damage, the target instead drops to 1 hit point, and the spell ends.\n"
					+ "If the spell is still in effect when the target is subjected to an effect that would kill it instantaneously without "
					+ "dealing damage, that effect is instead negated against the target, and the spell ends.";
			setSpell("1 action", "Touch", "V, S", "8 hours", 4, false);
			break;
		case "Delayed Blast Fireball":
			description = "A beam of yellow light flashes from your pointing finger, then condenses to linger at a chosen point within range "
					+ "as a glowing bead for the duration. When the spell ends, either because your concentration is broken or "
					+ "because you decide to end it, the bead blossoms with a low roar into an explosion of flame that spreads around "
					+ "corners. Each creature in a 20-foot-radius sphere centered on that point must make a Dexterity saving "
					+ "throw. A creature takes fire damage equal to the total accumulated damage on a failed save, or half as much damage on a successful one.\n"
					+ "The spell’s base damage is 12d6. If at the end of your turn the bead has not yet detonated, the damage increases by 1d6.\n"
					+ "If the glowing bead is touched before the interval has expired, the creature touching it must make a "
					+ "Dexterity saving throw. On a failed save, the spell ends immediately, causing the bead to erupt in flame. On a "
					+ "successful save, the creature can throw the bead up to 40 feet. When it strikes a creature or a solid object, the spell ends, and the bead explodes.\n"
					+ "The fire damages objects in the area and ignites flammable objects that aren’t being worn or carried.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 8th level or higher, the base damage increases by 1d6 for each slot level above 7th.";
			setSpell("1 action", "150 feet", "V, S, M (a tiny ball of bat guano and sulfur)", "Concentration, up to 1 minute", 7, false);
			break;
		case "Demiplane":
			description = "You create a shadowy door on a flat solid surface that you can see within range. The door is large enough to "
					+ "allow Medium creatures to pass through unhindered. When opened, the door leads to a demiplane that "
					+ "appears to be an empty room 30 feet in each dimension, made of wood or stone. When the spell ends, the door "
					+ "disappears, and any creatures or objects inside the demiplane remain trapped there, as the door also disappears from the other side.\n"
					+ "Each time you cast this spell, you can create a new demiplane, or have the shadowy door connect to a "
					+ "demiplane you created with a previous casting of this spell. Additionally, if you know the nature and contents "
					+ "of a demiplane created by a casting of this spell by another creature, you can have the shadowy door connect to its demiplane instead.";
			setSpell("1 action", "60 feet", "S", "1 hour", 8, false);
			break;
		case "Destructive Wave":
			description = "You strike the ground, creating a burst of divine energy that ripples outward from you. Each creature "
					+ "you choose within 30 feet of you must succeed on a Constitution saving throw or take 5d6 thunder damage, "
					+ "as well as 5d6 radiant or necrotic damage (your choice), and be knocked prone. A creature that succeeds on "
					+ "its saving throw takes half as much damage and isn’t knocked prone.";
			setSpell("1 action", "Self (30-foot radius)", "V", "Instantaneous", 5, false);
			break;
		case "Detect Evil and Good":
			description = "For the duration, you know if there is an aberration, celestial, elemental, fey, fiend, or undead within 30 "
					+ "feet of you, as well as where the creature is located. Similarly, you know if there is a place or object within "
					+ "30 feet of you that has been magically consecrated or desecrated.\n"
					+ "The spell can penetrate most barriers, but it is blocked by 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood or dirt.";
			setSpell("1ac", "Self", "V, S", "con10min", 1, false);
			break;
		case "Detect Magic":
			description = "For the duration, you sense the presence of magic within 30 feet of you. If you sense magic in this way, you "
					+ "can use your action to see a faint aura around any visible creature or object in the area that bears magic, and you "
					+ "learn its school of magic, if any.\n"
					+ "The spell can penetrate most barriers, but it is blocked by 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood or dirt.";
			setSpell("1ac", "Self", "V, S", "con10min", 1, true);
			break;
		case "Detect Poison and Disease":
			description = "For the duration, you can sense the presence and location of poisons, poisonous creatures, and diseases "
					+ "within 30 feet of you. You also identify the kind of poison, poisonous creature, or disease in each case.\n"
					+ "The spell can penetrate most barriers, but it is blocked by 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood or dirt.";
			setSpell("1ac", "Self", "V, S, M (a yew leaf)", "con10min", 1, true);
			break;
		case "Detect Thoughts":
			description = "For the duration, you can read the thoughts of certain creatures. When you cast the spell and as your action on "
					+ "each turn until the spell ends, you can focus your mind on any one creature that you can see within 30 feet of "
					+ "you. If the creature you choose has an Intelligence of 3 or lower or doesn’t speak any language, the creature is unaffected.\n"
					+ "You initially learn the surface thoughts of the creature — what is most on its mind in that moment. As "
					+ "an action, you can either shift your attention to another creature’s thoughts or attempt to probe deeper into the "
					+ "same creature’s mind. If you probe deeper, the target must make a Wisdom saving throw. If it fails, you gain "
					+ "insight into its reasoning (if any), its emotional state, and something that looms large in its mind (such as "
					+ "something it worries over, loves, or hates). If it succeeds, the spell ends. Either way, the target knows that you are "
					+ "probing into its mind, and unless you shift your attention to another creature’s thoughts, the creature can use "
					+ "its action on its turn to make an Intelligence check contested by your Intelligence check; if it succeeds, the spell ends.\n"
					+ "Questions verbally directed at the target creature naturally shape the course of its thoughts, so this spell "
					+ "is particularly effective as part of an interrogation.\n"
					+ "You can also use this spell to detect the presence of "
					+ "thinking creatures you can’t see. When you cast the spell or as your action during the duration, you can "
					+ "search for thoughts within 30 feet of you. The spell can penetrate barriers, but 2 feet of rock, 2 inches of any "
					+ "metal other than lead, or a thin sheet of lead blocks you. You can’t detect a creature with an Intelligence of 3 or "
					+ "lower or one that doesn’t speak any language.\n"
					+ "Once you detect the presence of a creature in this way, you can read its thoughts for the rest of the duration as "
					+ "described above, even if you can’t see it, but it must still be within range.";
			setSpell("1ac", "Self", "V, S, M (a copper piece)", "con10min", 2, false);
			break;
		case "Dimension Door":
			description = "You teleport yourself from your current location to any other spot within range. You arrive at exactly the spot "
					+ "desired. It can be a place you can see, one you can visualize, or one you can describe by stating distance "
					+ "and direction, such as “200 feet straight downward” or “upward to the northwest at a 45-degree angle, 300 feet.”\n"
					+ "You can bring along objects as long as their weight doesn’t exceed what you can carry. You can also bring "
					+ "one willing creature of your size or smaller who is carrying gear up to its carrying capacity. The creature "
					+ "must be within 5 feet of you when you cast this spell.\n"
					+ "If you would arrive in a place already occupied by an object or a creature, you and any creature traveling with "
					+ "you each take 4d6 force damage, and the spell fails to teleport you.";
			setSpell("1ac", "500 feet", "V", "in", 4, false);
			break;
		case "Disguise Self":
			description = "You make yourself — including your clothing, armor, weapons, and other belongings on your person — look "
					+ "different until the spell ends or until you use your action to dismiss it. You can seem 1 foot shorter or taller and "
					+ "can appear thin, fat, or in between. You can’t change your body type, so you must adopt a form that has the "
					+ "same basic arrangement of limbs. Otherwise, the extent of the illusion is up to you.\n"
					+ "The changes wrought by this spell fail to hold up to physical inspection. For example, if you use this spell "
					+ "to add a hat to your outfit, objects pass through the hat, and anyone who touches it would feel nothing or would "
					+ "feel your head and hair. If you use this spell to appear thinner than you are, the hand of someone who reaches "
					+ "out to touch you would bump into you while it was seemingly still in midair.\n"
					+ "To discern that you are disguised, a creature can use its action to inspect your appearance and must succeed "
					+ "on an Intelligence (Investigation) check against your spell save DC.";
			setSpell("1ac", "Self", "V, S", "1 hour", 1, false);
			break;
		case "Disintegrate":
			description = "A thin green ray springs from your pointing finger to a target that you can see within range. The target can be a "
					+ "creature, an object, or a creation of magical force, such as the wall created by wall of force.\n"
					+ "A creature targeted by this spell must make a Dexterity saving throw. On a failed save, the target takes "
					+ "10d6 + 40 force damage. If this damage reduces the target to 0 hit points, it is disintegrated.\n"
					+ "A disintegrated creature and everything it is wearing and carrying, except magic items, are reduced to a pile "
					+ "of fine gray dust. The creature can be restored to life only by means of a true resurrection or a wish spell.\n"
					+ "This spell automatically disintegrates a Large or smaller nonmagical object or a creation of magical "
					+ "force. If the target is a Huge or larger object or creation of force, this spell disintegrates a 10-foot-cube portion of "
					+ "it. A magic item is unaffected by this spell.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 7th level or higher, the damage increases by 3d6 for each slot level above 6th.";
			setSpell("1ac", "60 feet", "V, S, M (a lodestone and a pinch of dust)", "in", 6, false);
			break;
		case "Dispel Evil and Good":
			description = "Shimmering energy surrounds and protects you from fey, undead, and creatures originating from beyond the "
					+ "Material Plane. For the duration, celestials, elementals, fey, fiends, and undead have disadvantage on attack rolls against you.\n"
					+ "You can end the spell early by using either of the following special functions.\n"
					+ "Break Enchantment. As your action, you touch a creature you can reach that is charmed, frightened, or "
					+ "possessed by a celestial, an elemental, a fey, a fiend, or an undead. The creature you touch is no longer "
					+ "charmed, frightened, or possessed by such creatures.\n"
					+ "Dismissal. As your action, make a melee spell attack against a celestial, an elemental, a fey, a fiend, or an "
					+ "undead you can reach. On a hit, you attempt to drive the creature back to its home plane. The creature must "
					+ "succeed on a Charisma saving throw or be sent back to its home plane (if it isn't there already). If they aren’t on "
					+ "their home plane, undead are sent to the Shadowfell, and fey are sent to the Feywild.";
			setSpell("1ac", "Self", "V, S, M (holy water or powdered silver and iron)", "con1min", 5, false);
			break;
		case "Dispel Magic":
			description = "Choose one creature, object, or magical effect within range. Any spell of 3rd level or lower on the target ends. "
					+ "For each spell of 4th level or higher on the target, make an ability check using your spellcasting ability. The "
					+ "DC equals 10 + the spell’s level. On a successful check, the spell ends.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 4th level or higher, you automatically end "
					+ "the effects of a spell on the target if the spell’s level is equal to or less than the level of the spell slot you used.";
			setSpell("1ac", "120 feet", "V, S", "in", 3, false);
			break;
		case "Dissonant Whispers":
			description = "You whisper a discordant melody that only one creature of your choice within range can hear, wracking it with "
					+ "terrible pain. The target must make a Wisdom saving throw. On a failed save, it takes 3d6 psychic damage and "
					+ "must immediately use its reaction, if available, to move as far as its speed allows away from you. The creature "
					+ "doesn’t move into obviously dangerous ground, such as a fire or a pit. On a successful save, the target takes "
					+ "half as much damage and doesn’t have to move away. A deafened creature automatically succeeds on the save.\n"
					+ "At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.";
			setSpell("1ac", "60 feet", "V", "in", 1, false);
			break;
		case "Divination":
			description = "Your magic and an offering put you in contact with a god or a god’s servants. You ask a single question "
					+ "concerning a specific goal, event, or activity to occur within 7 days. The DM offers a truthful reply. The reply "
					+ "might be a short phrase, a cryptic rhyme, or an omen.\n"
					+ "The spell doesn’t take into account any possible circumstances that might change the outcome, such "
					+ "as the casting of additional spells or the loss or gain of a companion.\n"
					+ "If you cast the spell two or more times before finishing your next long rest, there is a cumulative 25 percent "
					+ "chance for each casting after the first that you get a random reading. The DM makes this roll in secret.";
			setSpell("1ac", "Self", "V, S, M (incense and a sacrificial offering appropriate to your religion, together worth at least 25 gp, which the "
					+ "spell consumes)", "in", 4, true);
			break;
		case "Divine Favor":
			description = "Your prayer empowers you with divine radiance. Until the spell ends, your weapon attacks deal an extra 1d4 radiant damage on a hit.";
			setSpell("1bonac", "Self", "V, S", "con1min", 1, false);
			break;
		case "Divine Word":
			description = "You utter a divine word, imbued with the power that shaped the world at the dawn of creation. Choose any "
					+ "number of creatures you can see within range. Each creature that can hear you must make a Charisma "
					+ "saving throw. On a failed save, a creature suffers an effect based on its current hit points:\n"
					+ "- 50 hit points or fewer: deafened for 1 minute\n"
					+ "- 40 hit points or fewer: deafened and blinded for 10 minutes\n"
					+ "- 30 hit points or fewer: blinded, deafened, and stunned for 1 hour\n"
					+ "- 20 hit points or fewer: killed instantly\n"
					+ "Regardless of its current hit points, a celestial, an elemental, a fey, or a fiend that fails its save is forced "
					+ "back to its plane of origin (if it isn’t there already) and can’t return to your current plane for 24 hours by any "
					+ "means short of a wish spell.";
			setSpell("1bonac", "30 feet", "V", "in", 7, false);
			break;
		case "Dominate Beast":
			description = "You attempt to beguile a beast that you can see within range. It must succeed on a Wisdom saving throw or be "
					+ "charmed by you for the duration. If you or creatures that are friendly to you are fighting it, it has advantage on the saving throw.\n"
					+ "While the beast is charmed, you have a telepathic link with it as long as the two of you are on the same plane "
					+ "of existence. You can use this telepathic link to issue commands to the creature while you are conscious (no "
					+ "action required), which it does its best to obey. You can specify a simple and general course of action, such as "
					+ "“Attack that creature,” “Run over there,” or “Fetch that object.” If the creature completes the order and doesn’t "
					+ "receive further direction from you, it defends and preserves itself to the best of its ability.\n"
					+ "You can use your action to take total and precise control of the target. Until the end of your next turn, the "
					+ "creature takes only the actions you choose, and doesn’t do anything that you don’t allow it to do. During this "
					+ "time, you can also cause the creature to use a reaction, but this requires you to use your own reaction as well.\n"
					+ "Each time the target takes damage, it makes a new Wisdom saving throw against the spell. If the saving throw succeeds, the spell ends.\n"
					+ "At Higher Levels. When you cast this spell with a 5th-level spell slot, the duration is concentration, up "
					+ "to 10 minutes. When you use a 6th-level spell slot, the duration is concentration, up to 1 hour. When you "
					+ "use a spell slot of 7th level or higher, the duration is concentration, up to 8 hours.";
			setSpell("1ac", "60 feet", "V, S", "con1min", 4, false);
			break;
		case "Dominate Monster":
			description = "You attempt to beguile a creature that you can see within range. It must succeed on a Wisdom saving "
					+ "throw or be charmed by you for the duration. If you or creatures that are friendly to you are fighting it, it has advantage on the saving throw.\n"
					+ "While the creature is charmed, you have a telepathic link with it as long as the two of you are on the same "
					+ "plane of existence. You can use this telepathic link to issue commands to the creature while you are conscious "
					+ "(no action required), which it does its best to obey. You can specify a simple and general course of action, such "
					+ "as “Attack that creature,” “Run over there,” or “Fetch that object.” If the creature completes the order and "
					+ "doesn’t receive further direction from you, it defends and preserves itself to the best of its ability.\n"
					+ "You can use your action to take total and precise control of the target. Until the end of your next turn, the "
					+ "creature takes only the actions you choose, and doesn’t do anything that you don’t allow it to do. During this "
					+ "time, you can also cause the creature to use a reaction, "
					+ "but this requires you to use your own reaction as well.\n"
					+ "Each time the target takes damage, it makes a new Wisdom saving throw against the spell. If the saving throw succeeds, the spell ends.\n"
					+ "At Higher Levels. When you cast this spell with a 9th-level spell slot, the duration is concentration, up to 8 hours.";
			setSpell("1ac", "60 feet", "V, S", "con1h", 8, false);
			break;
			//TODO:
		case "Dominate Person":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "con1min", 5, false);
			break;
		case "Drawmij's Instant Summons":
			description = "";
			setSpell("1min", "Touch", "V, S, M (a sapphire worth 1,000 gp)", "dis", 6, true);
			break;
		case "Dream":
			description = "";
			setSpell("1min", "Special", "V, S, M (a handful of sand, a dab of ink, and a writing quill plucked from a sleeping bird)", "8 hours", 5, false);
			break;
		case "Druidcraft":
			description = "";
			setSpell("1ac", "30 feet", "V, S", "in", 0, false);
			break;
		case "Earthquake":
			description = "";
			setSpell("1ac", "500 feet", "V, S, M (a pinch of dirt, a piece of rock, and a lump of clay)", "con1min", 8, false);
			break;
		case "Eldritch Blast":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "in", 0, false);
			break;
		case "Elemental Weapon":
			description = "";
			setSpell("1ac", "Touch", "V, S", "con1h", 3, false);
			break;
		case "Enhance Ability":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (fur or a feather from a beast)", "con1h", 2, false);
			break;
		case "Enlarge/Reduce":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a pinch of powdered iron)", "con1min", 2, false);
			break;
		case "Ensnaring Strike":
			description = "";
			setSpell("1bonac", "Self", "V", "con1min", 1, false);
			break;
		case "Entangle":
			description = "";
			setSpell("1ac", "90 feet", "V, S", "con1min", 1, false);
			break;
		case "Enthrall":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "1min", 2, false);
			break;
		case "Etherealness":
			description = "";
			setSpell("1ac", "Self", "V, S", "Up to 8 hours", 7, false);
			break;
		case "Evard's Black Tentacles":
			description = "";
			setSpell("1ac", "90 feet", "V, S, M (a piece of tentacle from a giant octopus or a giant squid)", "con1min", 4, false);
			break;
		case "Expeditious Retreat":
			description = "";
			setSpell("1bonac", "Self", "V, S", "con10min", 1, false);
			break;
		case "Eyebite":
			description = "";
			setSpell("1ac", "Self", "V, S", "con1min", 6, false);
			break;
		case "Fabricate":
			description = "";
			setSpell("10 minutes", "120 feet", "V, S", "in", 4, false);
			break;
		case "Faerie Fire":
			description = "";
			setSpell("1ac", "60 feet", "V", "con1min", 1, false);
			break;
		case "False Life":
			description = "";
			setSpell("1ac", "Self", "V, S, M (a small amount of alcohol or distilled spirits)", "1 hour", 1, false);
			break;
		case "Fear":
			description = "";
			setSpell("1ac", "Self (30-foot cone)", "V, S, M (a white feather or the heart of a hen)", "con1min", 3, false);
			break;
		case "Feather Fall":
			description = "";
			setSpell("1 reaction, which you take when you or a creature within 60 feet of you falls", "60 feet", "V, M (a small feather or piece of down)", "1min", 1, false);
			break;
		case "Feeblemind":
			description = "";
			setSpell("1ac", "150 feet", "V, S, M (a handful of clay, crystal, glass, or mineral spheres)", "in", 8, false);
			break;
		case "Feign Death":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a pinch of graveyard dirt)", "1 hour", 3, true);
			break;
		case "Find Familiar":
			description = "";
			setSpell("1 hour", "10 feet", "V, S, M (10 gp worth of charcoal, incense, and herbs that must be consumed by fire in a brass brazier)", "in", 1, true);
			break;
		case "Find Steed":
			description = "";
			setSpell("10 minutes", "30 feet", "V, S", "in", 2, false);
			break;
		case "Find the Path":
			description = "";
			setSpell("1 minute", "Self", "V, S, M (a set of divinatory tools — such "
					+ "as bones, ivory sticks, cards, teeth, or carved runes — worth 100 gp and an object from the location you wish to find)", "con1day", 6, false);
			break;
		case "Find Traps":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "in", 2, false);
			break;
		case "Finger of Death":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "in", 7, false);
			break;
		case "Fireball":
			description = "";
			setSpell("1ac", "150 feet", "V, S, M (a tiny ball of bat guano and sulfur)", "in", 3, false);
			break;
		case "Fire Bolt":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "in", 0, false);
			break;
		case "Fire Shield":
			description = "";
			setSpell("1ac", "Self", "V, S, M (a bit of phosphorous or a firefly)", "10min", 4, false);
			break;
		case "Fire Storm":
			description = "";
			setSpell("1ac", "150 feet", "V, S", "in", 7, false);
			break;
		case "Flame Blade":
			description = "";
			setSpell("1bonac", "Self", "V, S, M (a leaf of sumac)", "con10min", 2, false);
			break;
		case "Flame Strike":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a pinch of sulfur)", "in", 5, false);
			break;
		case "Flaming Sphere":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a bit of tallow, a pinch of brimstone, and a dusting of powdered iron)", "con1min", 2, false);
			break;
		case "Flesh to Stone":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a pinch of lime, water, and earth)", "con1min", 6, false);
			break;
		case "Fly":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a wing feather from any bird)", "con10min", 3, false);
			break;
		case "Fog Cloud":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "con1h", 1, false);
			break;
		case "Forbiddance":
			description = "";
			setSpell("10 minutes", "Touch", "V, S, M (a sprinkling of holy water, rare incense, and powdered ruby worth at least 1,000 gp)", "1 day", 6, true);
			break;
		case "Forcecage":
			description = "";
			setSpell("1ac", "100 feet", "V, S, M (ruby dust worth 1,500 gp)", "1 hour", 7, false);
			break;
		case "Foresight":
			description = "";
			setSpell("1min", "Touch", "V, S, M (a hummingbird feather)", "8 hours", 9, false);
			break;
		case "Freedom of Movement":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a leather strap, bound around the arm or a similar appendage)", "1 hour", 4, false);
			break;
		case "Friends":
			description = "";
			setSpell("1ac", "Self", "S, M (a small amount of makeup applied to the face as this spell is cast)", "con1min", 0, false);
			break;
		case "Gaseous Form":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a bit of gauze and a wisp of smoke)", "con1h", 3, false);
			break;
		case "Gate":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a diamond worth at least 5,000 gp)", "con1min", 9, false);
			break;
		case "Geas":
			description = "";
			setSpell("1min", "60 feet", "V", "30 days", 5, false);
			break;
		case "Gentle Repose":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a pinch of salt and one copper piece placed on each of the corpse's eyes, which must remain there "
					+ "for the duration)", "10 days", 2, true);
			break;
		case "Giant Insect":
			description = "";
			setSpell("1ac", "30 feet", "V, S", "con10min", 4, false);
			break;
		case "Glibness":
			description = "";
			setSpell("1ac", "Self", "V", "1 hour", 8, false);
			break;
		case "Globe of Invulnerability":
			description = "";
			setSpell("1ac", "Self (10-foot radius)", "V, S, M (a glass or crystal bead that shatters when the spell ends)", "con1min", 6, false);
			break;
		case "Glyph of Warding":
			description = "";
			setSpell("1 hour", "Touch", "V, S, M (incense and powdered diamond worth at least 200 gp, which the spell consumes)", "Until dispelled or triggered",
					3, false);
			break;
		case "Goodberry":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a sprig of mistletoe)", "in", 1, false);
			break;
		case "Grasping Vine":
			description = "";
			setSpell("1bonac", "30 feet", "V, S", "con1min", 4, false);
			break;
		case "Grease":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a bit of pork rind or butter)", "1 minute", 1, false);
			break;
		case "Greater Invisibility":
			description = "";
			setSpell("1ac", "Touch", "V, S", "con1min", 4, false);
			break;
		case "Greater Restoration":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (diamond dust worth at least 100 gp, which the spell consumes)", "in", 5, false);
			break;
		case "Guardian of Faith":
			description = "";
			setSpell("1ac", "30 feet", "V", "8 hours", 4, false);
			break;
		case "Guards and Wards":
			description = "";
			setSpell("10 minutes", "Touch", "V, S, M (burning incense, a small measure of brim stone and oil, a knotted string, a "
					+ "small amount of umber hulk blood, and a small silver rod worth at least 10 gp)", "24 hours", 6, false);
			break;
		case "Guidance":
			description = "";
			setSpell("1ac", "Touch", "V, S", "con1min", 0, false);
			break;
		case "Guiding Bolt":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "1 round", 1, false);
			break;
		case "Gust of Wind":
			description = "";
			setSpell("1ac", "Self (60-foot line)", "V, S, M (a legume seed)", "con1min", 2, false);
			break;
		case "Hail of Thorns":
			description = "";
			setSpell("1bonac", "Self", "V", "con1min", 1, false);
			break;
		case "Hallow":
			description = "";
			setSpell("24 hours", "Touch", "V, S, M (herbs, oils, and incense worth at least 1,000 gp, which the spell consumes)", "dis", 5, false);
			break;
		case "Hallucinatory Terrain":
			description = "";
			setSpell("10 minutes", "300 feet", "V, S, M (a stone, a twig, and a bit of green plant)", "24 hours", 4, false);
			break;
		case "Harm":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "in", 6, false);
			break;
		case "Haste":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a shaving of licorice root)", "con1min", 3, false);
			break;
		case "Heal":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "in", 6, false);
			break;
		case "Healing Word":
			description = "";
			setSpell("1bonac", "60 feet", "V", "in", 1, false);
			break;
		case "Heat Metal":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a piece of iron and a flame)", "con1min", 2, false);
			break;
		case "Hellish Rebuke":
			description = "";
			setSpell("1 reaction, which you take in response to being damaged by a creature within 60 feet of you that you can see", "60 feet", "V, S", "in", 1, false);
			break;
		case "Heroes' Feast":
			description = "";
			setSpell("10 minutes", "30 feet", "V, S, M (a gem-encrusted bowl worth at least 1,000 gp, which the spell consumes)", "in", 6, false);
			break;
		case "Heroism":
			description = "";
			setSpell("1ac", "Touch", "V, S", "con1min", 1, false);
			break;
		case "Hex":
			description = "";
			setSpell("1bonac", "90 feet", "V, S, M (the petrified eye of a newt)", "con1h", 1, false);
			break;
		case "Hold Monster":
			description = "";
			setSpell("1ac", "90 feet", "V, S, M (a small, straight piece of iron)", "con1min", 5, false);
			break;
		case "Hold Person":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a small, straight piece of iron)", "con1min", 2, false);
			break;
		case "Holy Aura":
			description = "";
			setSpell("1ac", "Self", "V, S, M (a tiny reliquary worth at least 1,000 gp containing a sacred relic, such as a scrap of "
					+ "cloth from a saint’s robe or a piece of parchment from a religious text)", "con1min", 8, false);
			break;
		case "Hunger of Hadar":
			description = "";
			setSpell("1ac", "150 feet", "V, S, M (a pickled octopus tentacle)", "con1min", 3, false);
			break;
		case "Hunter's Mark":
			description = "";
			setSpell("1bonac", "90 feet", "V", "con1h", 1, false);
			break;
		case "Hypnotic Pattern":
			description = "";
			setSpell("1ac", "120 feet", "S, M (a glowing stick of incense or a crystal vial filled with phosphorescent material)", "con1min", 3, false);
			break;
		case "Ice Storm":
			description = "";
			setSpell("1ac", "300 feet", "V, S, M (a pinch of dust and a few drops of water)", "in", 4, false);
			break;
		case "Identify":
			description = "";
			setSpell("1 minute", "Touch", "V, S, M (a pearl worth at least 100 gp and an owl feather)", "in", 1, true);
			break;
		case "Illusory Script":
			description = "";
			setSpell("1min", "Touch", "S, M (a lead-based ink worth at least 10 gp, which the spell consumes)", "10 days", 1, true);
			break;
		case "Imprisonment":
			description = "";
			setSpell("1 minute", "30 feet", "V, S, M (a vellum depiction or a carved statuette in the likeness of the target, and a special "
					+ "component that varies according to the version of the spell you choose, worth at least 500 gp per Hit Die of the target)", "dis", 9, false);
			break;
		case "Incendiary Cloud":
			description = "";
			setSpell("1ac", "150 feet", "V, S", "con1min", 8, false);
			break;
		case "Inflict Wounds":
			description = "";
			setSpell("1ac", "Touch", "V, S", "in", 1, false);
			break;
		case "Insect Plague":
			description = "";
			setSpell("1ac", "300 feet", "V, S, M (a few grains of sugar, some kernels of grain, and a smear of fat)", "con10min", 5, false);
			break;
		case "Invisibility":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (an eyelash encased in gum arabic)", "con1h", 2, false);
			break;
		case "Jump":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a grasshopper's hind leg)", "1 minute", 1, false);
			break;
		case "Knock":
			description = "";
			setSpell("1ac", "60 feet", "V", "in", 2, false);
			break;
		case "Legend Lore":
			description = "";
			setSpell("10 minutes", "Self", "V, S, M (incense worth at least 250 gp, which the spell consumes, and four ivory strips worth at least 50 gp each)", 
					"in", 5, false);
			break;
		case "Leomund's Secret Chest":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (an exquisite chest, 3 feet by 2 feet by 2 feet, constructed from rare materials worth at "
					+ "least 5,000 gp, and a Tiny replica made from the same materials worth at least 50 gp)", "in", 4, false);
			break;
		case "Leomund's Tiny Hut":
			description = "";
			setSpell("1 minute", "Self (10-foot radius hemisphere)", "V, S, M (a small crystal bead)", "8 hours", 3, true);
			break;
		case "Lesser Restoration":
			description = "";
			setSpell("1ac", "Touch", "V, S", "in", 2, false);
			break;
		case "Levitate":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (either a small leather loop or a piece of golden wire bent into a cup shape with a long shank on one end)", 
					"con10min", 2, false);
			break;
		case "Light":
			description = "";
			setSpell("1ac", "Touch", "V, M (a firefly or phosphorescent moss)", "1 hour", 0, false);
			break;
		case "Lightning Arrow":
			description = "";
			setSpell("1bonac", "Self", "V, S", "con1min", 3, false);
			break;
		case "Lightning Bolt":
			description = "";
			setSpell("1ac", "Self (100-foot line)", "V, S, M (a bit of fur and a rod of amber, crystal, or glass)", "in", 3, false);
			break;
		case "Locate Animals or Plants":
			description = "";
			setSpell("1ac", "Self", "V, S, M (a bit of fur from a bloodhound)", "in", 2, true);
			break;
		case "Locate Creature":
			description = "";
			setSpell("1ac", "Self", "V, S, M (a bit of fur from a bloodhound)", "con1h", 4, false);
			break;
		case "Locate Object":
			description = "";
			setSpell("1ac", "Self", "V, S, M (a forked twig)", "con10min", 2, false);
			break;
		case "Longstrider":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a pinch of dirt)", "1 hour", 1, false);
			break;
		case "Mage Armor":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a piece of cured leather)", "8 hours", 1, false);
			break;
		case "Mage Hand":
			description = "";
			setSpell("1ac", "30 feet", "V, S", "1 minute", 0, false);
			break;
		case "Magic Circle":
			description = "";
			setSpell("1 minute", "10 feet", " V, S, M (holy water or powdered silver and iron worth at least 100 gp, which the spell consumes)", "1 hour", 3, false);
			break;
		case "Magic Jar":
			description = "";
			setSpell("1 minute", "Self", "V, S, M (a gem, crystal, reliquary, or some other ornamental container worth at least 500 gp)", "dis", 6, false);
			break;
		case "Magic Missile":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "in", 1, false);
			break;
		case "Magic Mouth":
			description = "";
			setSpell("1 minute", "30 feet", "V, S, M (a small bit of honeycomb and jade dust worth at least 10 gp, which the spell consumes)", "dis", 2, true);
			break;
		case "Magic Weapon":
			description = "";
			setSpell("1bonac", "Touch", "V, S", "con1h", 2, false);
			break;
		case "Major Image":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a bit of fleece)", "con10min", 3, false);
			break;
		case "Mass Cure Wounds":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "in", 5, false);
			break;
		case "Mass Heal":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "in", 9, false);
			break;
		case "Mass Healing Word":
			description = "";
			setSpell("1bonac", "60 feet", "V", "in", 3, false);
			break;
		case "Mass Suggestion":
			description = "";
			setSpell("1ac", "60 feet", "V, M (a snake’s tongue and either a bit of honeycomb or a drop of sweet oil)", "24 hours", 6, false);
			break;
		case "Maze":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "con10min", 8, false);
			break;
		case "Meld into Stone":
			description = "";
			setSpell("1ac", "Touch", "V, S", "8 hours", 3, true);
			break;
		case "Melf's Acid Arrow":
			description = "";
			setSpell("1ac", "90 feet", "V, S, M (powdered rhubarb leaf and an adder's stomach)", "in", 2, false);
			break;
		case "Mending":
			description = "";
			setSpell("1 minute", "Touch", "V, S, M (two lodestones)", "in", 0, false);
			break;
		case "Message":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a short piece of copper wire)", "1 round", 0, false);
			break;
		case "Meteor Swarm":
			description = "";
			setSpell("1ac", "1 mile", "V, S", "in", 9, false);
			break;
		case "Mind Blank":
			description = "";
			setSpell("1ac", "Touch", "V, S", "24 hours", 8, false);
			break;
		case "Minor Illusion":
			description = "";
			setSpell("1ac", "30 feet", "S, M (a bit of fleece)", "1 minute", 0, false);
			break;
		case "Mirage Arcane":
			description = "";
			setSpell("10 minutes", "Sight", "V, S", "10 days", 7, false);
			break;
		case "Mirror Image":
			description = "";
			setSpell("1ac", "Self", "V, S", "1 minute", 2, false);
			break;
		case "Mislead":
			description = "";
			setSpell("1ac", "Self", "S", "con1h", 5, false);
			break;
		case "Misty Step":
			description = "";
			setSpell("1bonac", "Self", "V", "in", 2, false);
			break;
		case "Modify Memory":
			description = "";
			setSpell("1ac", "30 feet", "V, S", "con1min", 5, false);
			break;
		case "Moonbeam":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (several seeds of any moonseed plant and a piece of opalescent feldspar)", "con1min", 2, false);
			break;
		case "Mordenkainen's Faithful Hound":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a tiny silver whistle, a piece of bone, and a thread)", "8 hours", 4, false);
			break;
		case "Mordenkainen's Magnificent Mansion":
			description = "";
			setSpell("1 minute", "300 feet", "V, S, M (a miniature portal carved from ivory, a small piece of polished marble, and a tiny "
					+ "silver spoon, each item worth at least 5 gp)", "24 hours", 7, false);
			break;
		case "Mordenkainen's Private Sanctum":
			description = "";
			setSpell("10 minutes", "120 feet", "V, S, M (a thin sheet of lead, a piece of opaque glass, a wad of cotton or cloth, and powdered chrysolite)", 
					"24 hours", 4, false);
			break;
		case "Mordenkainen's Sword":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a miniature platinum sword with a grip and pommel of copper and zinc, worth 250 gp)", "con1min", 7, false);
			break;
		case "Move Earth":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (an iron blade and a small bag containing a mixture of soils — clay, loam, and sand)", "Concentration, up to 2 hours", 6, false);
			break;
		case "Nondetection":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a pinch of diamond dust worth 25 gp sprinkled over the target, which the spell consumes)", "8 hours", 3, false);
			break;
		case "Nystul's Magic Aura":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a small square of silk)", "24 hours", 2, false);
			break;
		case "Otiluke's Freezing Sphere":
			description = "";
			setSpell("1ac", "300 feet", "V, S, M (a small crystal sphere)", "in", 6, false);
			break;
		case "Otiluke's Resilient Sphere":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a hemispherical piece of clear crystal and a matching hemispherical piece of gum arabic)", "con1min", 4, false);
			break;
		case "Otto's Irresistable Dance":
			description = "";
			setSpell("1ac", "30 feet", "V", "con1min", 6, false);
			break;
		case "Pass Without Trace":
			description = "";
			setSpell("1ac", "Self", "V, S, M (ashes from a burned leaf of mistletoe and a sprig of spruce)", "con1h", 2, false);
			break;
		case "Passwall":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a pinch of sesame seeds)", "1 hour", 5, false);
			break;
		case "Phantasmal Force":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a bit of fleece)", "con1min", 2, false);
			break;
		case "Phantasmal Killer":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "con1min", 4, false);
			break;
		case "Phantom Steed":
			description = "";
			setSpell("1 minute", "30 feet", "V, S", "1 hour", 3, true);
			break;
		case "Planar Ally":
			description = "";
			setSpell("10 minutes", "60 feet", "V, S", "in", 6, false);
			break;
		case "Planar Binding":
			description = "";
			setSpell("1 hour", "60 feet", "V, S, M (a jewel worth at least 1,000 gp, which the spell consumes)", "24 hours", 5, false);
			break;
		case "Plane Shift":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a forked, metal rod worth at least 250 gp, attuned to a particular plane of existence)", "in", 7, false);
			break;
		case "Plant Growth":
			description = "";
			setSpell("1 action or 8 hours", "150 feet", "V, S", "in", 3, false);
			break;
		case "Poison Spray":
			description = "";
			setSpell("1ac", "10 feet", "V, S", "in", 0, false);
			break;
		case "Polymorph":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a caterpillar cocoon)", "con1h", 4, false);
			break;
		case "Power Word Heal":
			description = "";
			setSpell("1ac", "Touch", "V, S", "in", 9, false);
			break;
		case "Power Word Kill":
			description = "";
			setSpell("1ac", "60 feet", "V", "in", 9, false);
			break;
		case "Power Word Stun":
			description = "";
			setSpell("1ac", "60 feet", "V", "in", 8, false);
			break;
		case "Prayer of Healing":
			description = "";
			setSpell("10 minutes", "30 feet", "V", "in", 2, false);
			break;
		case "Prestidigitation":
			description = "";
			setSpell("1ac", "10 feet", "V, S", "Up to 1 hour", 0, false);
			break;
		case "Prismatic Spray":
			description = "";
			setSpell("1ac", "Self (60-foot cone)", "V, S", "in", 7, false);
			break;
		case "Prismatic Wall":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "10 minutes", 9, false);
			break;
		case "Produce Flame":
			description = "";
			setSpell("1ac", "Self", "V, S", "10 minutes", 0, false);
			break;
		case "Programmed Illusion":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a bit of fleece and jade dust worth at least 25 gp)", "dis", 6, false);
			break;
		case "Project Image":
			description = "";
			setSpell("1ac", "500 miles", "V, S, M (a small replica of you made from materials worth at least 5 gp)", "con1day", 7, false);
			break;
		case "Protection from Energy":
			description = "";
			setSpell("1ac", "Touch", "V, S", "con1h", 3, false);
			break;
		case "Protection from Evil and Good":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (holy water or powdered silver and iron, which the spell consumes)", "con10min", 1, false);
			break;
		case "Protection from Poison":
			description = "";
			setSpell("1ac", "Touch", "V, S", "1 hour", 2, false);
			break;
		case "Purify Food and Drink":
			description = "";
			setSpell("1ac", "10 feet", "V, S", "in", 1, true);
			break;
		case "Raise Dead":
			description = "";
			setSpell("1 hour", "Touch", "V, S, M (a diamond worth at least 500 gp, which the spell consumes)", "in", 5, false);
			break;
		case "Rary's Telepathic Bond":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (pieces of eggshell from two different kinds of creatures)", "1 hour", 5, true);
			break;
		case "Ray of Enfeeblement":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "con1min", 2, false);
			break;
		case "Ray of Frost":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "in", 0, false);
			break;
		case "Ray of Sickness":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "in", 1, false);
			break;
		case "Regenerate":
			description = "";
			setSpell("1 minute", "Touch", "V, S, M (a prayer wheel and holy water)", "1 hour", 7, false);
			break;
		case "Reincarnate":
			description = "";
			setSpell("1 hour", "Touch", "V, S, M (rare oils and unguents worth at least 1,000 gp, which the spell consumes)", "in", 5, false);
			break;
		case "Remove Curse":
			description = "";
			setSpell("1ac", "Touch", "V, S", "in", 3, false);
			break;
		case "Resistance":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a miniature cloak)", "con1min", 0, false);
			break;
		case "Resurrection":
			description = "";
			setSpell("1 hour", "Touch", "V, S, M (a diamond worth at least 1,000 gp, which the spell consumes)", "in", 7, false);
			break;
		case "Reverse Gravity":
			description = "";
			setSpell("1ac", "100 feet", "V, S, M (a lodestone and iron filings)", "con1min", 7, false);
			break;
		case "Revivify":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (diamonds worth 300 gp, which the spell consumes)", "in", 3, false);
			break;
		case "Rope Trick":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (powdered corn extract and a twisted loop of parchment)", "1 hour", 2, false);
			break;
		case "Sacred Flame":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "in", 0, false);
			break;
		case "Sanctuary":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a small silver mirror)", "1 minute", 1, false);
			break;
		case "Scorching Ray":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "in", 2, false);
			break;
		case "Scrying":
			description = "";
			setSpell("10 minutes", "Self", "V, S, M (a focus worth at least 1,000 gp, such as a crystal ball, a silver mirror, or a font filled with holy water)", 
					"con10min", 5, false);
			break;
		case "Searing Smite":
			description = "";
			setSpell("1bonac", "Self", "V", "con1min", 1, false);
			break;
		case "See Invisibility":
			description = "";
			setSpell("1ac", "Self", "V, S, M (a pinch of talc and a small sprinkling of powdered silver)", "1 hour", 2, false);
			break;
		case "Seeming":
			description = "";
			setSpell("1ac", "30 feet", "V, S", "8 hours", 5, false);
			break;
		case "Sending":
			description = "";
			setSpell("1ac", "Unlimited", "V, S, M (a short piece of fine copper wire)", "1 round", 3, false);
			break;
		case "Sequester":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a powder composed of diamond, emerald, ruby, and sapphire dust worth at least 5,000 gp, which the spell consumes)", 
					"dis", 7, false);
			break;
		case "Shapechange":
			description = "";
			setSpell("1ac", "Self", "V, S, M (a jade circlet worth at least 1,500 gp, which you must place on your head before you cast the spell)", "con1h", 9, false);
			break;
		case "Shatter":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a chip of mica)", "in", 2, false);
			break;
		case "Shield":
			description = "";
			setSpell("1 reaction, which you take when you are hit by an attack or targeted by the magic missile spell", "Self", "V, S", "1 round", 1, false);
			break;
		case "Shield of Faith":
			description = "";
			setSpell("1bonac", "60 feet", "V, S, M (a small parchment with a bit of holy text written on it)", "con10min", 1, false);
			break;
		case "Shillelagh":
			description = "";
			setSpell("1bonac", "Touch", "V, S, M (mistletoe, a shamrock leaf, and a club or quarterstaff)", "1 minute", 0, false);
			break;
		case "Shocking Grasp":
			description = "";
			setSpell("1ac", "Touch", "V, S", "in", 0, false);
			break;
		case "Silence":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "con10min", 2, true);
			break;
		case "Silent Image":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a bit of fleece)", "con10min", 1, false);
			break;
		case "Simulacrum":
			description = "";
			setSpell("12 hours", "Touch", "V, S, M (snow or ice in quantities sufficient to make a life-size copy of the duplicated "
					+ "creature; some hair, fingernail clippings, or other piece of that creature’s body placed inside the snow "
					+ "or ice; and powdered ruby worth 1,500 gp, sprinkled over the duplicate and consumed by the spell)", "dis", 7, false);
			break;
		case "Sleep":
			description = "";
			setSpell("1ac", "90 feet", "V, S, M (a pinch of fine sand, rose petals, or a cricket)", "1 minute", 1, false);
			break;
		case "Sleet Storm":
			description = "";
			setSpell("1ac", "150 feet", "V, S, M (a pinch of dust and a few drops of water)", "con1min", 3, false);
			break;
		case "Slow":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a drop of molasses)", "con1min", 3, false);
			break;
		case "Spare the Dying":
			description = "";
			setSpell("1ac", "Touch", "V, S", "in", 0, false);
			break;
		case "Speak with Animals":
			description = "";
			setSpell("1ac", "Self", "V, S", "10 minutes", 1, true);
			break;
		case "Speak with Dead":
			description = "";
			setSpell("1ac", "10 feet", "V, S, M (burning incense)", "10 minutes", 3, false);
			break;
		case "Speak with Plants":
			description = "";
			setSpell("1ac", "Self (30-foot radius)", "V, S", "10 minutes", 3, false);
			break;
		case "Spider Climb":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a drop of bitumen and a spider)", "con1h", 2, false);
			break;
		case "Spike Growth":
			description = "";
			setSpell("1ac", "150 feet", "V, S, M (seven sharp thorns or seven small twigs, each sharpened to a point)", "con10min", 2, false);
			break;
		case "Spirit Guardians":
			description = "";
			setSpell("1ac", "Self (15-foot radius)", "V, S, M (a holy symbol)", "con10min", 3, false);
			break;
		case "Spiritual Weapon":
			description = "";
			setSpell("1bonac", "60 feet", "V, S", "1 minute", 2, false);
			break;
		case "Staggering Smite":
			description = "";
			setSpell("1bonac", "Self", "V", "con1min", 4, false);
			break;
		case "Stinking Cloud":
			description = "";
			setSpell("1ac", "90 feet", "V, S, M (a rotten egg or several skunk cabbage leaves)", "con1min", 3, false);
			break;
		case "Stone Shape":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (soft clay, which must be worked into roughly the desired shape of the stone object)", "in", 4, false);
			break;
		case "Stoneskin":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (diamond dust worth 100 gp, which the spell consumes)", "con1h", 4, false);
			break;
		case "Storm of Vengeance":
			description = "";
			setSpell("1ac", "Sight", "V, S", "con1min", 9, false);
			break;
		case "Suggestion":
			description = "";
			setSpell("1ac", "30 feet", "V, M (a snake’s tongue and either a bit of honeycomb or a drop of sweet oil)", "Concentration, up to 8 hours", 2, false);
			break;
		case "Sunbeam":
			description = "";
			setSpell("1ac", "Self (60-foot line)", "V, S, M (a magnifying glass)", "con1min", 6, false);
			break;
		case "Sunburst":
			description = "";
			setSpell("1ac", "150 feet", "V, S, M (fire and a piece of sunstone)", "in", 8, false);
			break;
		case "Swift Quiver":
			description = "";
			setSpell("1bonac", "Touch", "V, S, M (a quiver containing at least one piece of ammunition)", "con1min", 5, false);
			break;
		case "Symbol":
			description = "";
			setSpell("1 minute", "Touch", "V, S, M (mercury, phosphorus, and powdered diamond and opal with a total value of at least 1,000 gp, which the spell consumes)", 
					"Until dispelled or triggered", 7, false);
			break;
		case "Tasha's Hideous Laughter":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (tiny tarts and a feather that is waved in the air)", "con1min", 1, false);
			break;
		case "Telekinesis":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "con10min", 5, false);
			break;
		case "Telepathy":
			description = "";
			setSpell("1ac", "Unlimited", "V, S, M (a pair of linked silver rings)", "24 hours", 8, false);
			break;
		case "Teleport":
			description = "";
			setSpell("1ac", "10 feet", "V", "in", 7, false);
			break;
		case "Teleportation Circle":
			description = "";
			setSpell("1 minute", "10 feet", "V, M (rare chalks and inks infused with precious gems with 50 gp, which the spell consumes)", "1 round", 5, false);
			break;
		case "Tenser's Floating Disk":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a drop of mercury)", "1 hour", 1, true);
			break;
		case "Thaumaturgy":
			description = "";
			setSpell("1ac", "30 feet", "V", "Up to 1 minute", 0, false);
			break;
		case "Thorn Whip":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (the stem of a plant with thorns)", "in", 0, false);
			break;
		case "Thunderous Smite":
			description = "";
			setSpell("1bonac", "Self", "V", "con1min", 1, false);
			break;
		case "Thunderwave":
			description = "";
			setSpell("1ac", "Self (15-foot cube)", "V, S", "in", 1, false);
			break;
		case "Time Stop":
			description = "";
			setSpell("1ac", "Self", "V", "in", 9, false);
			break;
		case "Tongues":
			description = "";
			setSpell("1ac", "Touch", "V, M (a small clay model of a ziggurat)", "1 hour", 3, false);
			break;
		case "Transport via Plants":
			description = "";
			setSpell("1ac", "10 feet", "V, S", "1 round", 6, false);
			break;
		case "Tree Stride":
			description = "";
			setSpell("1ac", "Self", "V, S", "con1min", 5, false);
			break;
		case "True Polymorph":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a drop of mercury, a dollop of gum arabic, and a wisp of smoke)", "con1h", 9, false);
			break;
		case "True Resurrection":
			description = "";
			setSpell("1 hour", "Touch", "V, S, M (a sprinkle of holy water and diamonds worth at least 25,000 gp, which the spell consumes)", "in", 9, false);
			break;
		case "True Seeing":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (an ointment for the eyes that costs 25 gp; is made from mushroom powder, saffron, and fat; and is consumed by the spell)", 
					"1 hour", 6, false);
			break;
		case "True Strike":
			description = "";
			setSpell("1ac", "30 feet", "S", "Concentration, up to 1 round", 0, false);
			break;
		case "Tsunami":
			description = "";
			setSpell("1 minute", "Sight", "V, S", "Concentration, up to 6 rounds", 8, false);
			break;
		case "Unseen Servant":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a piece of string and a bit of wood)", "1 hour", 1, true);
			break;
		case "Vampiric Touch":
			description = "";
			setSpell("1ac", "Self", "V, S", "con1min", 3, false);
			break;
		case "Vicious Mockery":
			description = "";
			setSpell("1ac", "60 feet", "V", "in", 0, false);
			break;
		case "Wall of Fire":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a small piece of phosphorus)", "con1min", 4, false);
			break;
		case "Wall of Force":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a pinch of powder made by crushing a clear gemstone)", "con10min", 5, false);
			break;
		case "Wall of Ice":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a small piece of quartz)", "con10min", 6, false);
			break;
		case "Wall of Stone":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a small block of granite)", "con10min", 5, false);
			break;
		case "Wall of Thorns":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a handful of thorns)", "con10min", 6, false);
			break;
		case "Warding Bond":
			description = "";
			setSpell("1ac", "Touch", "V, S, M (a pair of platinum rings worth at least 50 gp each, which you and the target must wear for the duration)", "1 hour", 2, false);
			break;
		case "Water Breathing":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a short reed or piece of straw)", "24 hours", 3, true);
			break;
		case "Water Walk":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a piece of cork)", "1 hour", 3, true);
			break;
		case "Web":
			description = "";
			setSpell("1ac", "60 feet", "V, S, M (a bit of spiderweb)", "con1h", 2, false);
			break;
		case "Weird":
			description = "";
			setSpell("1ac", "120 feet", "V, S", "con1min", 9, false);
			break;
		case "Wind Walk":
			description = "";
			setSpell("1 minute", "30 feet", "V, S, M (fire and holy water)", "8 hours", 6, false);
			break;
		case "Wind Wall":
			description = "";
			setSpell("1ac", "120 feet", "V, S, M (a tiny fan and a feather or exotic origin)", "con1min", 3, false);
			break;
		case "Wish":
			description = "";
			setSpell("1ac", "Self", "V", "in", 9, false);
			break;
		case "Witch Bolt":
			description = "";
			setSpell("1ac", "30 feet", "V, S, M (a twig from a tree that has been struck by lightning)", "con1min", 1, false);
			break;
		case "Word of Recall":
			description = "";
			setSpell("1ac", "5 feet", "V", "in", 6, false);
			break;
		case "Wrathful Smite":
			description = "";
			setSpell("1bonac", "Self", "V", "con1min", 1, false);
			break;
		case "Zone of Truth":
			description = "";
			setSpell("1ac", "60 feet", "V, S", "10 minutes", 2, false);
			break;
		default:
			b = false;
		}
		return b;
	}
	
	// to make life easier
	private void setSpell(String castTime, String range, String components, String duration, int level, boolean ritual) {
		switch (castTime) {
		case "1ac":
			this.castTime = "1 action";
			break;
		case "1bonac":
			this.castTime = "1 bonus action";
			break;
		case "1min":
			this.castTime = "1 minute";
			break;
		default:
			this.castTime = castTime;
		}
		switch (duration) {
		case "con10min":
			this.duration = "Concentration, up to 10 minutes";
			break;
		case "con1min":
			this.duration = "Concentration, up to 1 minute";
			break;
		case "in":
			this.duration = "Instantaneous";
			break;
		case "con1h":
			this.duration = "Concentration, up to 1 hour";
			break;
		case "con1day":
			this.duration = "Concentration, up to 1 day";
			break;
		case "dis":
			this.duration = "Until dispelled";
			break;
		case "1min":
			this.duration = "1 minute";
			break;
		case "10min":
			this.duration = "10 minutes";
		default:
			this.duration = duration;
		}
		this.range = range;
		this.components = components;
		this.level = level;
		this.ritual = ritual;
	}
	
	// getters
	public String getName() { return name; }
	public String getCastTime() { return castTime; }
	public String getRange() { return range; }
	public String getComponents() { return components; }
	public String getDuration() { return duration; }
	public String getDescription() { return description; }
	public int getLevel() { return level; }
	public boolean isRitual() { return ritual; }

}
