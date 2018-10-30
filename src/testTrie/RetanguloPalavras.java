package testTrie;

import java.util.ArrayList;
import java.util.List;

import Action.utils.LerArquivo;

public class RetanguloPalavras
{

	private int tamanhoMaiorPalavra;
	private GrupoPalavras[] listaGrupos;
	private Trie trieList[];

	public RetanguloPalavras(String[] list) {
		listaGrupos = GrupoPalavras.criarGrupoPalavras(list);
		tamanhoMaiorPalavra = listaGrupos.length;
		trieList = new Trie[tamanhoMaiorPalavra];
	}

	public Retangulo maiorRetangulo()
	{
		int maiorArea = tamanhoMaiorPalavra * tamanhoMaiorPalavra;

		for (int i = maiorArea; i > 0; i--)
		{
			for (int j = 1; j <= tamanhoMaiorPalavra; j++)
			{
				// System.out.println(i + " " + j + " " + i%j + " "+ i/j);
				if (i % j == 0)
				{
					int razao = i / j;
					if (razao <= tamanhoMaiorPalavra)
					{
						Retangulo retangulo = montarRetangulo(j, razao);
						if (retangulo != null)
						{
							return retangulo;
						}
					}
				}
			}
		}
		return null;
	}

	private Retangulo montarRetangulo(int largura, int altura)
	{
		if (listaGrupos[largura - 1] == null || listaGrupos[altura - 1] == null)
		{
			return null;
		}
		if (trieList[altura - 1] == null)
		{
			ArrayList<String> palavras = listaGrupos[altura - 1].getPalavras();
			trieList[altura - 1] = new Trie(palavras);
		}
		return tentarMontarRetangulo(largura, altura, new Retangulo(largura));
	}

	private Retangulo tentarMontarRetangulo(int largura, int altura, Retangulo retangulo)
	{

		if (retangulo.altura == altura)
		{
			if (retangulo.estaCheio(largura, altura, listaGrupos[altura - 1]))
			{
				return retangulo;
			}
			else
			{
				return null;
			}
		}

		if (!retangulo.ehValido(largura, trieList[altura - 1]))
		{
			return null;
		}

		for (int i = 0; i < listaGrupos[largura - 1].tamanho(); i++)
		{
			Retangulo retanguloAValidar = retangulo.adicionar(listaGrupos[largura - 1].getPalavra(i));
			Retangulo novoRetangulo = tentarMontarRetangulo(largura, altura, retanguloAValidar);
			if (novoRetangulo != null)
			{
				return novoRetangulo;
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		
		LerArquivo arquivo = new LerArquivo();
		List<String> dataset = arquivo.getDataset();
		
		RetanguloPalavras retanguloPalavras = new RetanguloPalavras(dataset.toArray(new String[dataset.size()]));
		Retangulo retangulo = retanguloPalavras.maiorRetangulo();
		if (retangulo != null)
		{
			retangulo.mostrarRetangulo();
		}
		else
		{
			System.out.println("Nao existe um retangulo valido");
		}
	}
	
	public static String[] lista1k()
	{
		String[] lista =
		{ "a", "able", "about", "above", "accept", "accident", "account", "accuse", "across", "act", "activist",
				"actor", "add", "administration", "admit", "adult", "advertisement", "advise", "affect", "afraid",
				"after", "again", "against", "age", "agency", "aggression", "ago", "agree", "agriculture", "aid", "aim",
				"air", "air", "airplane", "airport", "album", "alive", "all", "ally", "almost", "alone", "along",
				"already", "also", "although", "always", "ammunition", "among", "amount", "anarchy", "ancestor",
				"ancient", "and", "anger", "angle", "angry", "animal", "anniversary", "announce", "another", "answer",
				"any", "apologize", "appeal", "appear", "apple", "appoint", "approve", "area", "argue", "arm", "army",
				"around", "arrest", "arrive", "art", "artillery", "as", "ash", "ask", "assist", "astronomy", "at",
				"atmosphere", "attach", "attack", "attempt", "attend", "attention", "authority", "automatic",
				"automobile", "autumn", "average", "avoid", "awake", "award", "away", "baby", "back", "bad", "bag",
				"balance", "ball", "balloon", "ballot", "ban", "bank", "bar", "barrier", "base", "basket", "battle",
				"be", "beat", "beautiful", "because", "become", "bed", "before", "begin", "behind", "believe", "bell",
				"belong", "below", "bend", "best", "betray", "better", "between", "big", "bill", "billion", "biology",
				"bird", "birth", "bite", "black", "blade", "blame", "blanket", "bleed", "blind", "block", "blood",
				"blow", "blue", "board", "boat", "body", "bomb", "bone", "book", "border", "born", "borrow", "both",
				"bottle", "bottom", "box", "boy", "boycott", "brain", "brake", "branch", "brass", "brave", "bread",
				"break", "breathe", "brick", "bridge", "brief", "bright", "bring", "broadcast", "brother", "brown",
				"brush", "budget", "build", "building", "bullet", "burn", "burst", "bury", "bus", "business", "busy",
				"but", "butter", "button", "buy", "by", "cabinet", "call", "calm", "camera", "camp", "campaign", "can",
				"cancel", "cancer", "candidate", "capital", "capture", "car", "card", "care", "careful", "carriage",
				"carry", "case", "cash", "cat", "catch", "cause", "celebrate", "center", "century", "ceremony",
				"certain", "chain", "chairman", "champion", "chance", "change", "charge", "chase", "cheer", "cheese",
				"chemical", "chemistry", "chest", "chief", "child", "choose", "church", "circle", "citizen", "city",
				"civilian", "claim", "clash", "clean", "clear", "climate", "climb", "clock", "close", "cloth", "cloud",
				"coal", "coast", "coat", "coffee", "cold", "collar", "collect", "college", "colony", "color", "combine",
				"come", "comfort", "command", "comment", "committee", "common", "communicate", "community", "company",
				"compare", "compete", "complete", "complex", "compromise", "computer", "concern", "condemn",
				"condition", "conference", "confirm", "congratulate", "congress", "connect", "conservative", "consider",
				"contain", "continent", "continue", "control", "convention", "cook", "cool", "cooperate", "copy",
				"cork", "corn", "correct", "cost", "cotton", "count", "country", "court", "cover", "cow", "crash",
				"create", "creature", "credit", "crew", "crime", "criminal", "crisis", "criticize", "crush", "cry",
				"culture", "cup", "cure", "current", "curtain", "custom", "cut", "damage", "dance", "danger", "dark",
				"date", "daughter", "day", "dead", "deaf", "deal", "dear", "debate", "debt", "decide", "declare",
				"decrease", "deep", "defeat", "defend", "deficit", "define", "degree", "delay", "delicate", "demand",
				"democracy", "demonstrate", "denounce", "deny", "depend", "deploy", "depression", "describe", "desert",
				"design", "desire", "destroy", "detail", "develop", "device", "dictator", "die", "diet", "different",
				"dig", "dinner", "diplomat", "direct", "direction", "dirt", "disappear", "disarm", "discover",
				"discuss", "disease", "disk", "dismiss", "dispute", "dissident", "distance", "divide", "do", "doctor",
				"document", "dog", "dollar", "door", "doubt", "down", "drain", "dream", "dress", "drink", "drive",
				"drop", "drug", "dry", "during", "dust", "duty", "each", "ear", "early", "earn", "earth", "ease",
				"east", "easy", "eat", "ecology", "economy", "edge", "education", "effect", "effort", "egg", "eight",
				"either", "elastic", "electricity", "eleven", "else", "embassy", "emergency", "emotion", "employ",
				"empty", "end", "enemy", "energy", "enforce", "engine", "engineer", "enjoy", "enough", "enter",
				"environment", "equal", "equipment", "escape", "especially", "establish", "estimate", "ethnic",
				"evaporate", "even", "event", "ever", "every", "evidence", "evil", "examine", "example", "excellent",
				"except", "exchange", "excuse", "execute", "exercise", "exile", "exist", "expand", "expect",
				"experience", "experiment", "expert", "explain", "explode", "explore", "export", "express", "extend",
				"extra", "extreme", "eye", "face", "fact", "factory", "fail", "fair", "fall", "false", "family",
				"famous", "far", "fast", "fat", "father", "fear", "feather", "feed", "feel", "female", "fertile", "few",
				"field", "fierce", "fifteen", "fifth", "fifty", "fight", "fill", "film", "final", "finance", "find",
				"fine", "finger", "finish", "fire", "firm", "first", "fish", "fist", "fit", "five", "fix", "flag",
				"flat", "float", "floor", "flow", "flower", "fluid", "fly", "fog", "follow", "food", "fool", "foolish",
				"foot", "for", "forbid", "force", "force", "foreign", "forest", "forget", "forgive", "form", "former",
				"forty", "forward", "four", "frame", "free", "freedom", "freeze", "fresh", "friend", "frighten", "from",
				"front", "fruit", "fuel", "full", "fun", "future", "gain", "game", "garden", "gas", "gather", "general",
				"get", "gift", "girl", "give", "glass", "go", "goal", "god", "gold", "good", "govern", "government",
				"grass", "great", "green", "grey", "ground", "group", "grow", "guarantee", "guard", "guide", "guilty",
				"gun", "hair", "half", "halt", "hand", "hang", "happen", "happy", "hard", "harmony", "hat", "hate",
				"have", "he", "head", "headquarters", "heal", "health", "healthy", "hear", "heart", "heat", "heavy",
				"helicopter", "help", "her", "here", "hers", "hide", "high", "hijack", "hill", "him", "his", "history",
				"hit", "hold", "hole", "holiday", "hollow", "holy", "home", "honest", "honor", "hope", "horrible",
				"horse", "hospital", "hostage", "hostile", "hot", "hotel", "hour", "house", "how?", "however", "huge",
				"human", "humor", "hundred", "hunger", "hunt", "hurry", "hurt", "husband", "I", "ice", "idea",
				"identify", "if", "ill", "illegal", "imagine", "immediate", "import", "important", "improve", "in",
				"incident", "include", "increase", "independent", "individual", "industry", "infect", "inflation",
				"influence", "inform", "information", "inject", "injure", "innocent", "insane", "inspect", "instead",
				"instrument", "insult", "insurance", "intelligence", "intense", "interest", "interfere",
				"international", "into", "invade", "invent", "invest", "investigate", "invite", "involve", "iron",
				"island", "issue", "it", "jacket", "jail", "jewel", "job", "join", "joint", "joke", "judge", "jump",
				"jury", "just", "keep", "key", "kick", "kill", "kind", "kiss", "kit", "knife", "know", "knowledge",
				"labor", "laboratory", "lack", "lake", "land", "language", "large", "last", "late", "laugh", "law",
				"lead", "leak", "learn", "leave", "left", "leg", "legal", "lend", "less", "letter", "level", "library",
				"lie", "life", "lift", "light", "like", "limit", "line", "link", "lip", "liquid", "list", "listen",
				"little", "live", "load", "loan", "local", "lock", "long", "look", "loose", "lose", "loud", "love",
				"low", "loyal", "luck", "machine", "magazine", "mail", "main", "majority", "make", "male", "man",
				"manufacture", "many", "map", "march", "mark", "market", "marry", "match", "material", "matter", "may",
				"mayor", "meal", "mean", "measure", "meat", "media", "medicine", "meet", "member", "memory", "mental",
				"mercy", "message", "metal", "method", "middle", "might", "military", "milk", "million", "mind", "mine",
				"minister", "minor", "minute", "miss", "mist", "mistake", "mix", "mob", "model", "moderate", "modern",
				"money", "month", "moon", "moral", "more", "morning", "most", "mother", "mountain", "mouth", "move",
				"movie", "much", "murder", "muscle", "music", "must", "my", "mystery", "nail", "name", "narrow",
				"nation", "native", "natural", "navy", "near", "necessary", "neck", "neither", "nerve", "neutral",
				"never", "new", "news", "next", "nice", "night", "nine", "ninth", "no", "noise", "nominate", "noon",
				"normal", "north", "nose", "not", "note", "nothing", "now", "nowhere", "nuclear", "number", "obey",
				"object", "observe", "occupy", "ocean", "of", "off", "offensive", "offer", "office", "officer",
				"official", "often", "oil", "old", "on", "once", "one", "only", "open", "operate", "opinion",
				"opposite", "oppress", "or", "orange", "order", "organize", "other", "our", "ours", "oust", "out",
				"over", "owe", "own", "page", "pain", "paint", "pan", "pants", "paper", "parade", "parallel", "parcel",
				"parent", "parliament", "part", "party", "pass", "passenger", "passport", "past", "paste", "path",
				"patient", "pay", "peace", "pen", "pencil", "people", "percent", "perfect", "perform", "period",
				"permanent", "permit", "person", "physical", "picture", "piece", "pig", "pilot", "pipe", "place",
				"plan", "plant", "plastic", "plate", "play", "please", "plenty", "pocket", "point", "poison", "police",
				"policy", "politics", "pollute", "poor", "popular", "population", "port", "position", "possess",
				"possible", "postpone", "potato", "pour", "powder", "power", "praise", "pray", "pregnant", "present",
				"president", "press", "pressure", "prevent", "price", "print", "prison", "private", "prize", "probable",
				"problem", "process", "produce", "professor", "profit", "program", "progress", "project", "property",
				"propose", "protect", "protest", "prove", "provide", "public", "publish", "pull", "punish", "purchase",
				"pure", "purpose", "push", "put", "quality", "question", "quick", "quiet", "quit", "race", "radar",
				"radiation", "radio", "raid", "rail", "rain", "raise", "rare", "rate", "ray", "reach", "react", "read",
				"ready", "real", "realistic", "reason", "receive", "recession", "recognize", "record", "recover", "red",
				"reduce", "refugee", "refuse", "regret", "reject", "relation", "release", "religion", "remain",
				"remember", "remove", "repair", "repeat", "report", "represent", "request", "require", "rescue",
				"research", "resign", "resist", "resolution", "resource", "respect", "responsible", "rest", "restrain",
				"result", "retire", "return", "revolt", "reward", "rice", "rich", "ride", "right", "riot", "rise",
				"risk", "river", "road", "rob", "rock", "rocket", "roll", "roof", "room", "root", "rope", "rough",
				"round", "rubber", "ruin", "rule", "run", "sabotage", "sacrifice", "sad", "safe", "sail", "salt",
				"same", "sand", "satellite", "satisfy", "save", "say", "scale", "school", "science", "sea", "search",
				"season", "seat", "second", "secret", "security", "see", "seek", "seem", "seize", "seldom", "self",
				"sell", "senate", "send", "sense", "sentence", "separate", "series", "serious", "serve", "set",
				"settle", "seven", "several", "severe", "sex", "shade", "shake", "shall", "shame", "shape", "share",
				"sharp", "she", "shelf", "shell", "shelter", "shine", "ship", "shirt", "shock", "shoe", "shoot",
				"short", "should", "shout", "show", "shrink", "shut", "sick", "side", "sign", "signal", "silence",
				"silk", "silver", "similar", "simple", "since", "sing", "single", "sister", "sit", "situation", "six",
				"size", "skeleton", "skill", "skin", "skirt", "sky", "slave", "sleep", "slide", "slip", "slow", "small",
				"smash", "smell", "smile", "smoke", "smooth", "snake", "sneeze", "snow", "so", "soap", "social",
				"society", "soft", "soil", "soldier", "solid", "solve", "some", "son", "soon", "sort", "soul", "sound",
				"south", "space", "speak", "special", "speech", "speed", "spend", "spirit", "sport", "spread", "spring",
				"spy", "square", "stand", "star", "start", "starve", "station", "statue", "stay", "steal", "steam",
				"steel", "step", "stick", "still", "stomach", "stone", "stop", "store", "storm", "story", "straight",
				"strange", "street", "stretch", "strike", "strong", "structure", "struggle", "study", "stupid",
				"subject", "substance", "substitute", "succeed", "such", "sudden", "suffer", "sugar", "suggest",
				"summer", "sun", "supervise", "supply", "support", "suppose", "suppress", "sure", "surface", "surprise",
				"surrender", "surround", "survive", "suspect", "suspend", "swallow", "swear", "sweet", "swim",
				"sympathy", "system", "table", "tail", "take", "talk", "tall", "target", "taste", "tax", "tea", "teach",
				"team", "tear", "technical", "technology", "telephone", "television", "tell", "ten", "term", "terrible",
				"territory", "terror", "test", "than", "thank", "that", "the", "theater", "their", "theirs", "them",
				"then", "theory", "there", "these", "they", "thick", "thin", "thing", "think", "third", "thirteen",
				"thirty", "this", "though", "thought", "thousand", "threaten", "three", "through", "throw", "tie",
				"tight", "time", "tin", "tired", "to", "today", "together", "tomorrow", "tongue", "tonight", "too",
				"tool", "tooth", "top", "torture", "total", "touch", "toward", "town", "trade", "tradition", "traffic",
				"train", "transport", "travel", "treason", "treasure", "treat", "treatment", "treaty", "tree", "trial",
				"tribe", "trick", "trip", "troop", "trouble", "truck", "true", "trust", "try", "tube", "turn", "twelve",
				"twenty", "twice", "two", "under", "understand", "unite", "universe", "university", "unless", "until",
				"up", "urge", "urgent", "us", "use", "usual", "valley", "value", "vegetable", "vehicle", "version",
				"very", "veto", "vicious", "victim", "victory", "village", "violate", "violence", "visit", "voice",
				"vote", "wage", "wait", "walk", "wall", "want", "war", "warm", "warn", "wash", "waste", "watch",
				"water", "wave", "way", "we", "weak", "wealth", "weapon", "wear", "weather", "week", "weight",
				"welcome", "well", "west", "wet", "what", "wheat", "wheel", "when", "where", "which", "while", "white",
				"who", "whole", "why", "wide", "wife", "wild", "will", "win", "wind", "window", "wine", "wing",
				"winter", "wire", "wise", "wish", "with", "withdraw", "without", "woman", "wonder", "wonderful", "wood",
				"wool", "word", "work", "world", "worry", "worse", "worth", "wound", "wreck", "write", "wrong", "year",
				"yellow", "yes", "yesterday", "yet", "you", "young", "your", "yours", "zero" };
		return lista;
	}

	public static String[] dataset()
	{
		String[] dataset =
		{ "the", "of", "and", "a", "to", "in", "is", "be", "that", "was", "world", "awesome", "he", "for", "it", "with",
				"as", "his", "I", "on", "have", "at", "by", "not", "surely", "they", "this", "attract", "computer",
				"had", "are", "but", "from", "or", "she", "an", "which", "you", "one", "we", "all", "were", "her",
				"would", "there", "their", "will", "when", "who", "him", "been", "has", "more", "if", "no", "out", "do",
				"so", "can", "what", "up", "said", "about", "other", "into", "than", "its", "time", "only", "could",
				"new", "them", "man", "some", "these", "then", "two", "first", "May", "any", "like", "now", "my",
				"such", "make", "over", "our", "even", "most", "me", "state", "after", "also", "made", "many", "did",
				"must", "before", "back", "see", "through", "way", "where", "get", "much", "go", "well", "your", "know",
				"should", "down", "work", "year", "because", "come", "people", "just", "say", "each", "those", "take",
				"day", "good", "how", "long", "Mr", "own", "too", "little", "use", "us", "very", "great", "still",
				"men", "here", "life", "both", "between", "old", "under", "last", "never", "place", "same", "another",
				"think", "abuse", "house", "while", "high", "right", "might", "came", "off", "find", "states", "since",
				"used", "give", "against", "three", "himself", "look", "few", "general", "heart", "hand", "school",
				"resin", "part", "small", "American", "home", "during", "number", "again", "Mrs", "around", "thought",
				"went", "without", "however", "govern", "don't", "does", "got", "public", "United", "point", "end",
				"become", "head", "once", "course", "fact", "upon", "need", "system", "set", "every", "trend", "war",
				"put", "form", "water", "took", "program", "present", "government", "thing", "told", "possible",
				"group", "large", "until", "always", "city", "didn't", "order", "away", "called", "want", "eyes",
				"something", "unite", "going", "face", "far", "asked", "interest", "later", "show", "knew", "though",
				"less", "night", "early", "almost", "let", "open", "enough", "side", "case", "days", "yet", "better",
				"nothing", "tell", "problem", "toward", "given", "why", "national", "room", "young", "social", "light",
				"business", "president", "help", "power", "country", "next", "things", "word", "looked", "real", "John",
				"line", "second", "church", "seem", "certain", "big", "Four", "felt", "several", "children", "service",
				"feel", "important", "rather", "name", "per", "among", "often", "turn", "development",
				"developmentcomputer", "keep", "family", "seemed", "white", "company", "mind", "members", "others",
				"within", "done", "along", "turned", "god", "sense", "week", "best", "change", "kind", "began", "child",
				"ever", "law", "matter", "least", "means", "question", "act", "close", "mean", "leave", "itself",
				"force", "study", "York", "action", "it's", "door", "experience", "human", "result", "times", "run",
				"different", "car", "example", "hands", "whole", "center", "although", "call", "Five", "inform", "gave",
				"plan", "woman", "boy", "feet", "provide", "taken", "thus", "body", "play", "seen", "today", "having",
				"cost", "perhaps", "field", "local", "really", "am", "increase", "reason", "themselves", "clear", "I'm",
				"information", "figure", "late", "above", "history", "love", "girl", "held", "special", "move",
				"person", "whether", "college", "sure", "probably", "either", "seems", "cannot", "art", "free",
				"across", "death", "quite", "street", "value", "anything", "making", "past", "brought", "moment",
				"control", "office", "heard", "problems", "became", "full", "near", "half", "nature", "hold", "live",
				"available", "known", "board", "effect", "already", "Economic", "money", "position", "believe", "age",
				"together", "shall", "TRUE", "political", "court", "report", "level", "rate", "air", "pay", "community",
				"complete", "music", "necessary", "society", "behind", "type", "read", "idea", "wanted", "land",
				"party", "class", "organize", "return", "department", "education", "following", "mother", "sound",
				"ago", "nation", "voice", "six", "bring", "wife", "common", "south", "strong", "town", "book",
				"students", "hear", "hope", "able", "industry", "stand", "tax", "west", "meet", "particular", "cut",
				"short", "stood", "university", "spirit", "start", "total", "future", "front", "low", "century",
				"Washington", "usually", "care", "recent", "evidence", "further", "million", "simple", "road",
				"sometimes", "support", "view", "fire", "says", "hard", "morning", "table", "left", "situation", "try",
				"outside", "lines", "surface", "ask", "modern", "top", "peace", "personal", "member", "minutes", "lead",
				"schools", "talk", "consider", "gone", "soon", "father", "ground", "living", "months", "therefore",
				"America", "started", "longer", "Dr", "dark", "various", "finally", "hour", "north", "third", "fall",
				"greater", "pressure", "stage", "expected", "secretary", "needed", "That's", "kept", "eye", "values",
				"union", "private", "alone", "black", "required", "space", "subject", "english", "month", "understand",
				"I'll", "nor", "answer", "moved", "amount", "conditions", "direct", "red", "student", "rest", "nations",
				"heart", "costs", "record", "picture", "taking", "couldn't", "hours", "deal", "forces", "everything",
				"write", "coming", "effort", "market", "island", "wall", "purpose", "basis", "east", "lost", "St",
				"except", "letter", "looking", "property", "Miles", "difference", "entire", "else", "color", "followed",
				"feeling", "son", "makes", "friend", "basic", "cold", "including", "single", "attention", "note",
				"cause", "hundred", "step", "paper", "developed", "tried", "simply", "can't", "story", "committee",
				"inside", "reached", "easy", "appear", "include", "accord", "Actually", "remember", "beyond", "dead",
				"shown", "fine", "religious", "continue", "ten", "defense", "getting", "Central", "beginning",
				"instead", "river", "received", "doing", "employ", "trade", "terms", "trying", "friends", "sort",
				"administration", "higher", "cent", "expect", "food", "building", "religion", "meeting", "ready",
				"walked", "follow", "earth", "speak", "passed", "foreign", "NATURAL", "medical", "training", "County",
				"list", "floor", "piece", "especially", "indeed", "stop", "wasn't", "England", "difficult", "likely",
				"Suddenly", "moral", "plant", "bad", "club", "needs", "international", "working", "countries",
				"develop", "drive", "reach", "police", "sat", "charge", "farm", "fear", "test", "determine", "hair",
				"results", "stock", "trouble", "happened", "growth", "square", "William", "cases", "effective", "serve",
				"miss", "involved", "doctor", "earlier", "increased", "being", "blue", "hall", "particularly", "boys",
				"paid", "sent", "production", "district", "using", "thinking", "concern", "Christian", "press", "girls",
				"wide", "usual", "direction", "feed", "trial", "walk", "begin", "weeks", "points", "respect",
				"certainly", "ideas", "industrial", "methods", "operation", "addition", "association", "combine",
				"knowledge", "decided", "temperature", "statement", "Yes", "below", "game", "nearly", "science",
				"directly", "horse", "influence", "size", "showed", "build", "throughout", "questions", "character",
				"foot", "Kennedy", "firm", "reading", "husband", "doubt", "services", "according", "lay", "stay",
				"programs", "anyone", "average", "French", "spring", "former", "summer", "bill", "lot", "chance", "due",
				"comes", "army", "actual", "Southern", "neither", "relate", "rise", "evening", "normal", "wish",
				"visit", "population", "remain", "measure", "merely", "arrange", "condition", "decision", "account",
				"opportunity", "pass", "demand", "strength", "window", "active", "deep", "degree", "ran", "western",
				"E", "sales", "continued", "fight", "heavy", "arm", "standard", "generally", "carry", "hot", "provided",
				"serious", "led", "wait", "hotel", "opened", "performance", "maybe", "station", "changes", "literature",
				"marry", "claim", "works", "bed", "wrong", "main", "unit", "George", "hit", "planning", "supply",
				"systems", "add", "chief", "officer", "Soviet", "pattern", "stopped", "price", "success", "lack",
				"myself", "truth", "freedom", "manner", "quality", "gun", "manufacture", "clearly", "share", "movement",
				"length", "ways", "burn", "forms", "Organization", "break", "somewhat", "efforts", "cover", "meaning",
				"progress", "treatment", "beautiful", "placed", "happy", "attack", "apparently", "blood", "groups",
				"carried", "sign", "radio", "dance", "I've", "regard", "man's", "train", "herself", "numbers", "corner",
				"REACTION", "immediately", "language", "running", "recently", "shake", "larger", "lower", "machine",
				"attempt", "learn", "couple", "race", "audience", "Oh", "middle", "brown", "date", "health", "persons",
				"understanding", "arms", "daily", "suppose", "additional", "hospital", "pool", "technical", "served",
				"declare", "described", "current", "poor", "steps", "reported", "sun", "based", "produce", "determined",
				"receive", "park", "staff", "faith", "responsibility", "Europe", "latter", "British", "season", "equal",
				"learned", "practice", "green", "writing", "ones", "choice", "fiscal", "term", "watch", "scene",
				"activity", "product", "types", "ball", "heat", "clothe", "lived", "distance", "parent", "letters",
				"returned", "forward", "obtained", "offer", "specific", "straight", "fix", "division", "slowly", "shot",
				"poet", "seven", "moving", "mass", "plane", "proper", "propose", "drink", "obviously", "plans",
				"whatever", "afternoon", "figures", "parts", "approve", "saying", "born", "immediate", "fame", "gives",
				"extent", "justice", "cars", "mark", "pretty", "opinion", "ahead", "glass", "refuse", "enter",
				"completely", "send", "desire", "judge", "none", "waiting", "popular", "Democratic", "film", "mouth",
				"Corps", "importance", "touch", "director", "ship", "there's", "council", "EFFECTS", "event", "worth",
				"existence", "designed", "hardly", "indicated", "analysis", "established", "products", "growing",
				"patient", "rule", "bridge", "pain", "base", "check", "cities", "elements", "leaders", "discussion",
				"limited", "sit", "Thomas", "agreement", "gas", "factors", "marriage", "easily", "closed", "excite",
				"accept", "applied", "allow", "bit", "married", "oil", "Rhode", "shape", "interested", "strange",
				"compose", "professional", "remained", "news", "Despite", "beauty", "responsible", "wonder", "spent",
				"tear", "unless", "eight", "permit", "covered", "Negro", "played", "I'd", "vote", "balance", "Charles",
				"loss", "Commission", "original", "fair", "reasons", "studies", "exactly", "built", "behavior", "enemy",
				"teeth", "bank", "die", "James", "relations", "weight", "prepared", "related", "sea", "bar", "warn",
				"post", "trees", "official", "separate", "clay", "Sunday", "raised", "events", "thin", "dropped",
				"cattle", "invite", "playing", "prevent", "detail", "standing", "grow", "places", "someone", "bright",
				"Talking", "meant", "print", "capital", "happen", "sides", "everyone", "facilities", "filled", "lip",
				"essential", "techniques", "June", "knows", "stain", "hadn't", "dinner", "dog", "dollars", "caught",
				"shout", "buy", "divide", "entered", "Chicago", "speed", "jazz", "appoint", "governor", "institutions",
				"fit", "materials", "sight", "store", "dependence", "explain", "gain", "he'd", "leadership", "quiet",
				"realize", "parents", "Communist", "neighbor", "round", "included", "kitchen", "thousand", "Christ",
				"isn't", "radiation", "broad", "stops", "failure", "retire", "election", "primary", "king", "books",
				"command", "edge", "ember", "March", "sitting", "conference", "bottom", "lady", "advise", "churches",
				"model", "battle", "giving", "sport", "address", "considerable", "spread", "funds", "trip", "youth",
				"CONSTRUCTION", "rock", "regular", "changed", "boat", "memory", "successful", "captain", "hell",
				"brother", "murder", "quick", "moreover", "highly", "difficulty", "inch", "saw", "clean", "collect",
				"camp", "experiment", "shows", "Authority", "older", "lord", "variety", "material", "frame",
				"distinguish", "scientific", "introduce", "principal", "Jack", "kill", "collection", "fell",
				"entertain", "pieces", "management", "otherwise", "security", "danger", "entirely", "civil",
				"frequently", "advertise", "records", "secret", "title", "impossible", "yesterday", "fast", "Mike",
				"produced", "favor", "noted", "caused", "lose", "purposes", "solid", "song", "corporation", "lie",
				"winter", "dress", "electric", "key", "dry", "reduce", "fresh", "goes", "hill", "names", "slow",
				"quickly", "telephone", "threaten", "oppose", "deliver", "officers", "expression", "published",
				"famous", "pray", "adopt", "London", "clothes", "laws", "citizens", "announced", "minute", "master",
				"sharp", "advantage", "greatest", "relation", "Mary", "leaving", "gray", "manager", "animal", "object",
				"bottle", "draw", "honor", "recognize", "drop", "intend", "relationship", "opposite", "sources",
				"poetry", "ability", "assistance", "operating", "bear", "join", "climb", "companies", "exist", "fixed",
				"gradual", "possibility", "hunt", "spoke", "satisfy", "units", "neck", "sleep", "doesn't", "finished",
				"carefully", "facts", "nice", "practical", "save", "takes", "allowed", "wine", "remind", "rich",
				"financial", "dream", "knife", "stations", "civilize", "Rose", "cool", "died", "thick", "imagine",
				"literary", "bind", "inches", "earn", "familiar", "seeing", "distribution", "marked", "coffee", "rules",
				"slip", "apply", "page", "beside", "daughter", "Relatively", "classes", "explore", "stated", "German",
				"musical", "smile", "significant", "block", "mix", "reports", "PROPOSED", "shelter", "presence",
				"Affairs", "named", "ordinary", "circumstances", "mile", "sweep", "remains", "admire", "Catholic",
				"dust", "operations", "rain", "tree", "nobody", "Henry", "Robert", "village", "advance", "offered",
				"agree", "mechanic", "upper", "occasion", "requirements", "capacity", "appears", "travel", "article",
				"houses", "valley", "beat", "opening", "box", "evil", "succeed", "surround", "application", "slightly",
				"remembered", "interests", "warm", "subjects", "search", "presented", "shoe", "sweet", "interesting",
				"membership", "suggest", "notice", "connection", "extreme", "exchange", "flow", "spend", "everybody",
				"poems", "campaign", "win", "forced", "freeze", "nine", "eat", "newspaper", "please", "escape", "lives",
				"swim", "file", "wind", "provides", "shop", "apartment", "fashion", "reasonable", "created", "Germany",
				"watched", "cells", "session", "somehow", "fully", "whose", "teacher", "raise", "recognized", "unity",
				"Providence", "reference", "explained", "twenty", "Russian", "features", "shoulder", "sir", "forest",
				"studied", "Sam", "signal", "chair", "reduced", "procedure", "forth", "limit", "disturb", "universe",
				"mentioned", "pick", "reality", "differences", "soft", "traditional", "Mission", "flat", "looks",
				"picked", "weather", "smaller", "leg", "chairman", "ancient", "narrow", "fellow", "twist", "belief",
				"excellent", "rights", "vocational", "laid", "politics", "fill", "response", "struggle", "disappear",
				"prove", "duty", "FOLLOWS", "editor", "welcome", "anode", "possess", "hearing", "BUILDINGS", "ideal",
				"scientist", "formed", "watching", "circle", "ought", "garden", "library", "accuse", "message",
				"slight", "junior", "knock", "empty", "protection", "treated", "birth", "expressed", "planned",
				"choose", "confuse", "Virginia", "killed", "frighten", "stayed", "worry", "surprise", "aside",
				"photograph", "removed", "turning", "Jr", "pull", "personnel", "agency", "pointed", "speech", "listen",
				"November", "sample", "Louis", "motor", "selected", "Berlin", "CLAIMS", "spot", "strike", "increasing",
				"exercise", "handle", "hole", "Leader", "baby", "ride", "avoid", "cross", "twice", "commercial",
				"failed", "prompt", "fat", "fourth", "visitor", "interior", "Jewish", "wing", "desk", "faculty",
				"forget", "operate", "stair", "besides", "relief", "standards", "France", "perfect", "pour",
				"Nevertheless", "brief", "Jones", "kick", "attend", "plus", "solution", "wage", "individuals", "powers",
				"minister", "taste", "discovered", "pulled", "hire", "writer", "verb", "preach", "friendly", "observed",
				"fan", "connect", "Fig", "count", "egg", "items", "mention", "Texas", "calculate", "platform", "drag",
				"mere", "tomorrow", "faces", "pure", "fighting", "resources", "increases", "assumed", "broke", "coast",
				"strict", "whom", "Russia", "qualify", "Morgan", "victory", "fields", "pleasure", "contain", "fold",
				"review", "April", "teach", "Richard", "whisper", "chosen", "metal", "PRINCIPLES", "competition",
				"railroad", "safe", "proved", "carrying", "horses", "kiss", "Mercer", "wheel", "sail", "wants",
				"compared", "relieve", "approximately", "wood", "historical", "persuade", "smiled", "crowd", "motion",
				"shore", "suit", "calls", "seat", "deserve", "San", "snow", "double", "educational", "neighborhood",
				"relative", "teachers", "Independent", "puzzle", "nose", "dogs", "waited", "naturally", "stone",
				"origin", "Rome", "wild", "scale", "tremble", "drawn", "guess", "communism", "absence", "roof",
				"sections", "sky", "walls", "Aircraft", "complain", "independence", "busy", "elect", "revolution",
				"roar", "willing", "League", "mine", "nurse", "liberal", "completed", "poem", "dollar", "ordered",
				"levels", "ton", "settled", "allowance", "bitter", "realized", "let's", "moon", "sensitive", "servant",
				"hunger", "China", "sale", "appearance", "lips", "policies", "actions", "strengthen", "Monday", "onto",
				"directed", "leading", "machinery", "theater", "Paris", "Frank", "somewhere", "Statements", "mill",
				"projects", "starting", "hat", "ruin", "depend", "stands", "signs", "families", "stir", "Khrushchev",
				"largely", "punish", "drew", "breathe", "amuse", "characteristic", "electronic", "pale", "pictures",
				"destroy", "expense", "somebody", "completion", "disappoint", "fifty", "found", "soil", "flame",
				"enjoy", "bless", "emotional", "promise", "she'd", "wave", "commerce", "Jury", "bay", "tempt",
				"correct", "asking", "content", "estimated", "conscious", "shine", "teaching", "catch", "dish",
				"Saturday", "greet", "background", "flood", "insect", "worse", "yellow", "occurred", "afraid",
				"ceremony", "decrease", "trust", "yourself", "legs", "you've", "communication", "describe", "sincere",
				"decide", "leaf", "encourage", "rub", "declared", "cry", "bite", "July", "lung", "significance",
				"helped", "gross", "apart", "disease", "issues", "scratch", "dictionary", "risk", "broadcast", "drum",
				"representative", "uncle", "cutting", "Jesus", "neglect", "depth", "substantial", "GETS", "adventure",
				"beg", "entrance", "plays", "throw", "ends", "Arts", "alive", "confidence", "intellectual", "cheer",
				"properties", "experiments", "nut", "plenty", "beneath", "closely", "description", "melt", "swear",
				"tall", "loose", "area", "bury", "measured", "request", "ourselves", "stream", "wipe", "band",
				"fingers", "creature", "Hanover", "attorney", "load", "passing", "billion", "earnest", "discussed",
				"translate", "achievement", "headquarters", "inquiry", "rapidly", "express", "hesitate", "guard",
				"jobs", "borrow", "owe", "Phil", "California", "ambition", "supposed", "lake", "they're", "slope",
				"Typical", "spite", "wore", "dear", "employees", "map", "pair", "spin", "one's", "praise",
				"imagination", "hung", "instrument", "plow", "holding", "objects", "straighten", "dominant", "scarce",
				"ring", "matters", "creep", "plain", "resolution", "credit", "period", "improve", "maintenance",
				"seize", "Laos", "we'll", "dozen", "located", "dig", "towards", "curse", "major", "breath", "weigh",
				"comfort", "federal", "guests", "priest", "sell", "bodies", "female", "primarily", "cousin", "grew",
				"spiritual", "dine", "engine", "politician", "custom", "educate", "individual", "job", "Tom", "cook",
				"grass", "mail", "salesman", "nail", "tap", "wet", "bedroom", "sufficient", "chest", "dramatic",
				"silence", "behave", "breakfast", "sudden", "passage", "scatter", "objection", "unusual", "argument",
				"policy", "powerful", "throat", "formal", "rapid", "Parker", "wrap", "luck", "grind", "rifle",
				"HIGHEST", "loan", "represent", "skill", "spell", "broken", "arch", "angle", "sick", "swell", "blind",
				"Contemporary", "engineer", "military", "boundary", "location", "homes", "boil", "officials",
				"operator", "Senate", "lend", "hearts", "embers", "abused", "resins", "trendy", "ssdsy" };
		return dataset;
	}
}
