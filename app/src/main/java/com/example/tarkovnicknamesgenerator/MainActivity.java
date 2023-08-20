package com.example.tarkovnicknamesgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private EditText nickEditText;
    private Button nickButton;
    private Button copyButton;
    private RadioButton threeRadioButton;
    private RadioButton anyRadioButton;
    private CheckBox numbersCheckBox;
    private CheckBox translitCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nickEditText = findViewById(R.id.nickEditText);
        nickButton = findViewById(R.id.nickButton);
        copyButton = findViewById(R.id.copyButton);
        threeRadioButton = findViewById(R.id.threeRadioButton);
        anyRadioButton = findViewById(R.id.anyRadioButton);
        numbersCheckBox = findViewById(R.id.numbersCheckBox);
        translitCheckBox = findViewById(R.id.translitCheckBox);

        anyRadioButton.setChecked(true);

        nickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> keywordsEN = new ArrayList<>();
                Collections.addAll(keywordsEN, "Escape", "Tarkov", "Survival", "Shooter", "Military", "PMC",
                        "Raid", "Loot", "Scav", "Battlestate", "Gear", "Weapon", "Armor", "Ammo",
                        "Quest", "Custom", "Factory",
                        "Lab", "Hideout", "Trader", "Market", "Secure", "Container", "Stash", "Health",
                        "Stamina", "Skill", "Lvl", "Level", "PVP", "PVE", "Squad",
                        "Teamplay", "Tactical", "Realism", "Hardcore", "Firefight", "Gunfight",
                        "Cover", "Stealth", "Grenade", "Supplie", "FirstAid", "Bandage",
                        "Painkiller", "Backpack", "Helmet", "NightVision",
                        "Silencer", "Optics", "Attachment", "Barter", "Reputation", "Bitcoin", "Roubles",
                        "Dollars", "Euros", "Modding", "Scope", "Foregrips", "Stocks", "ArmorPlates",
                        "Helmet", "Point", "Zone", "Time", "Tactic", "Camping", "Camper",
                        "Camp", "Distance", "Map", "Key", "Guide", "Strategie", "Tips", "Gameplay",
                        "Raid", "Loot", "Ammo", "Mosinka",
                        "Armor", "Meds", "AKM", "M4A1", "SA58", "ASVAL", "Scope",
                        "RPK", "SKS", "Roubles", "Rubles", "Bear", "USEC",
                        "AK74", "M4", "ASVAL", "SKS45",
                        "Armor", "MedKit", "Split", "IFAK", "CMS", "Gold",
                        "CPU", "PSU", "SSD", "HDD", "RAM", "5x45", "7x62", "5x56", "9x19",
                        "Raids", "Loot", "Custom",
                        "Reserve", "Factory", "Ammo", "Armor", "Meds", "Extract", "AKM",
                        "M4A1", "SA58", "ASVAL", "Sniper", "Scope", "Raider", "Shturm", "RPK",
                        "SKS", "Roubles", "Rubles", "Bear", "USEC", "Raid", "Gear",
                        "Tark", "Exfil", "PMC", "SVD", "AK74", "M1A",  "SKS", "RSASS", "M700", "MP5",
                        "AKS", "AKMS", "Saiga", "VSS", "VAL", "M9", "MPX", "PP-19", "P90", "Glock", "Mak", "TT",
                        "Grach", "APS", "APB", "MP443",
                        "Killa", "Reshala", "Sanitar", "Glukhar", "Shturman", "Cult", "Tagilla", "Sniper",
                        "Boss", "Dealmaker", "Punisher", "ScavBoss", "Thief", "Nomad", "Hermit",
                        "Guide", "Plague", "Ghost", "Stalker", "Reaper", "Predator", "Saboteur",
                        "Hunter", "Executor", "Destroyer", "Warlord", "Shadow", "Enforcer",
                        "Vandal", "Marauder", "Bandit", "Outlaw", "Raider", "Mercenary", "Gunner",
                        "Marksman", "Rogue", "Thief", "Bandit", "Scout",
                        "Pioneer", "Survivor",  "Captain", "Commander", "Leader",
                        "Strategist", "Tactician", "Engineer", "Scientist", "Inventor", "Pilot",
                        "Navigator", "Driver", "Rider",
                        "Juggernaut", "Tank", "Bouncer", "Crusher", "Slayer", "Executor",
                        "Annihilator", "Conqueror", "Scavenger", "Raid", "Loot", "Wood", "Ammo",
                        "Armor", "Meds", "Mosin", "AKM", "M4A1", "SA58", "ASVAL", "Scope", "Killa",
                        "Vepr", "SKS", "Bear", "USEC",
                        "AK74", "M4", "ASVAL", "SKS45", "Ammo",
                        "Armor", "Med", "Kit", "Split", "IFAK", "Morphi", "Gold",
                        "CPU", "SSD", "HDD", "RAM", "M995", "BS", "BT", "BP",
                        "T45M", "VPO", "AKSU", "AKM", "PMC", "Raids", "Loot",
                        "Reserve", "Factory", "Ammo", "Armor", "Meds", "Extract", "AKM",
                        "M4A1", "SA58", "ASVAL", "Sniper", "Scope", "Raider", "Killa",
                        "SKS", "Roubles", "Rubles", "Bear", "USEC", "Raid", "Gear",
                        "PMC", "SVD", "AK74", "M1A", "RSASS", "MP7",
                        "AKS", "Saiga", "VSS", "VAL", "M9", "MPX", "PP-19", "P-90", "Glock", "Mak", "TT",
                        "TT", "Grach", "APS", "APB", "MP443",
                        "PMCex", "Raid", "Loot", "Labs", "Woods", "Ammo",
                        "Armor", "Meds", "AKM", "M4A1", "SA58", "ASVAL", "Scope", "Tagilla",
                        "SKS", "Bear", "USEC", "AK74", "M4",
                        "ASVAL", "SKS45", "TOZ-106", "TarkovStreets",
                        "Armor", "Med", "Kit", "Split", "IFAK", "CMS", "Gold", "VPO", "RPK", "Toxic",
                        "Prapor", "Therapist", "Fence", "Skier", "Peacekeeper", "Mechanic", "Ragman", "Jaeger",
                        "Cheh", "Box200", "Box300", "Boxer", "Zinc", "Souls", "Fubar", "Salewa",
                        "Chiter", "AxeMan", "Mosiner", "AKSU", "MR-133", "NATO", "NatoAK",
                        "Lemon", "Trofy", "FullGear", "Polejaikin", "PreFire", "Tap", "OneShot", "Vendor",
                        "Nikita", "Geneburn", "Trainfender", "Bread", "DogHome");

                ArrayList<String> uniqueKeywordsEN = keywordsEN.stream()
                        .distinct()
                        .collect(Collectors.toCollection(ArrayList::new));

                ArrayList<String> keywordsRU = new ArrayList<>();
                Collections.addAll(keywordsRU, "Pobeg", "Tarkov", "Vyzhivanie", "Shuter", "Voennyj",
                        "CHVK", "Rejd", "Dobycha", "Dikiy", "Battlestate", "Snaryazhenie", "Oruzhie", "Bronya",
                        "Patrony", "Zadanie", "Kastom", "Fabrika", "Laboratoriya", "Ubezhishche", "Trejder",
                        "Rynok", "Bezopasnyj", "Kontejner", "Yashchik", "Zdorove", "Vynoslivost", "Navyk",
                        "Uroven", "PVP", "PVE", "Komanda", "Komandnaya", "Takticheskij", "Realizm", "Toxic",
                        "Hardkor", "Ukrytie", "Skrytnost", "Granata", "Pripasy",
                        "Pervaya pomoshch", "Bint", "Obezbolivayushchee", "Ryukzak", "SHlem", "Nochnoe videnie",
                        "Glushitel", "Optika", "Prisposoblenie", "Barter", "Reputaciya", "Bitkoin", "Rubli",
                        "Dollary", "Evro", "Modding", "Pricel", "Predpuskovoi", "Priklad", "Broneplastin",
                        "SHlem", "Tochka", "Zona", "Vremya", "Taktika", "Kemping", "Kemper", "Lager", "Distanciya",
                        "Karta", "Klyuch", "Rukovodstvo", "Strategiya", "Sovet", "GamePlay", "Reid", "Dobycha",
                        "Patron", "Mosinka", "Bronya", "Medikamenty", "AKM", "M4A1", "SA58", "ASVAL", "Pricel",
                        "RPK", "SKS", "Rubli", "Rubli", "Medkomplekt", "Razdelenie", "IFAK", "CMS", "Zoloto", "CPU",
                        "BP", "SSD", "HDD", "OZU", "5x45", "7x62", "5x56", "9x19", "Dobycha",
                        "Tamozhnya", "Zavod", "Laboratoriya", "Rezerv", "Razvyazka", "Bereg", "Les", "UlicyTarkova",
                         "Patrony", "Bronya", "Medikamenty", "Ekstrakt", "AKM", "M4A1",
                        "SA58", "ASVAL", "Snajper", "Pricel", "Rejder", "SHturm", "RPK", "SKS", "Rubli", "Rubli",
                                "Medved", "USEC", "AK74", "M4", "ASVAL", "SKS45", "Bronya", "MedNabor",
                        "IFAK", "CMS", "Zoloto", "CPU", "SSD", "OZU", "M995", "BS",
                        "BT", "BP", "T45M", "VPO", "AKSU", "AKM", "CHVK", "Rejdy", "Dobycha",
                                "Pricel", "Rejder", "Killa", "SKS", "Rubli",
                        "Snaryazhenie", "Tark", "Eksfil", "CHVK", "SVD", "AK74", "M1A", "SKS", "RSASS", "M700",
                        "MP5", "AKS", "AKMS", "Sajga", "VSS", "VAL", "M9", "MPX", "PP-19", "P90", "Glock", "Makarov",
                        "TT", "Grach", "APS", "APB", "MP443", "Killa", "Reshala", "Sanitar", "Gluhar", "Shturman",
                        "Kult", "Tagila", "Snaiper", "Boss", "Torgovec", "Naemnik", "Zhulik", "Nomad", "Otshelnik",
                        "Rukovodstvo", "Prizrak", "Stalker", "ZHnec", "Hishchnik", "Sabotazhnik", "Ohotnik",
                        "Ispolnitel", "Razrushitel", "Vandal", "Maroder", "Bandit",
                        "Vne zakona", "Reider", "Naemnik", "Strelok", "Lezvie", "Krestonosec", "Berserk", "Viking",
                        "Razbojnik", "Vor", "Bandit", "Skaut", "Pervoprohodec", "Vyzhivshij", "Kapitan", "Komandir",
                        "Lider", "Strateg", "Taktik", "Inzhener", "Uchenyj", "Pilot", "Navigator", "Voditel",
                        "Prapor", "Terapevt", "Skupshchik", "Lyzhnik", "Mirotvorec", "Mekhanik", "Baraholshchik", "Eger",
                        "Vsadnik", "Tank", "Vyshibala", "Drobilka", "Ubijca", "Ispolnitel", "Annigilyator",
                        "Pokoritel", "Plut", "Rejd", "Dobycha", "Les", "Patrony", "Bronya", "Medikamenty", "Mosin", "AKM", "M4A1",
                        "SA58", "ASVAL", "Pricel", "Killa", "Vepr", "SKS", "Medved", "USEC", "AK74", "M4", "ASVAL", "SKS45",
                        "Patrony", "Bronya", "Medicina", "Nabor", "Razdelenie", "IFAK", "Morfij", "Zoloto", "CPU", "SSD",
                        "OZU", "M995", "BS", "BT", "BP", "T45M", "VPO", "AKSU", "AKM", "CHVK",
                        "Dobycha", "Laboratorii", "Les", "Patrony", "Bronya", "Medikamenty", "AKM", "M4A1", "SA58", "ASVAL",
                        "Tagila", "SKS", "Medved", "USEC", "AK74", "M4", "ASVAL", "SKS45", "Tozik", "Bronya",
                        "Medicina", "Nabor", "Razdelenie", "IFAK", "CMS", "Zoloto", "VPO", "RPK", "Gruz200",
                        "Gruz300", "Bokser", "Cheh", "Duh", "Fubar", "Salewa", "Chiter", "Toporist", "Mosinist",
                        "Ksyuha", "Murka", "Dikij", "CHVK", "NATO", "NatoAK", "Limonka", "Trofei", "Fulka", "Polezhajkin",
                        "Prifaer", "Tap", "Vanshot", "Torgovec", "Nikita", "Baton", "Budka", "Geneburn");

                ArrayList<String> uniqueKeywordsRU = keywordsRU.stream()
                        .distinct()
                        .collect(Collectors.toCollection(ArrayList::new));


                String[] keywords3 = {"EFT", "TSK", "PMC", "RAI", "LOO", "SCA", "BSG", "GEA", "WPN",
                        "ARM", "AMO", "QST", "EXT", "CUS", "WOO", "FAC", "SHO", "INT", "LAB", "HID",
                        "TRD", "MRK", "SEC", "CON", "STA", "HLT", "STM", "SKL", "LVL", "SCA", "PVP",
                        "PVE", "SQD", "TMP", "TAC", "RLM", "HCR", "FTF", "GFT", "AMB", "COV", "SUP",
                        "STL", "GRN", "SPL", "FAD", "BND", "PKR", "FOD", "WTR", "BPK", "HLM", "VST",
                        "NVS", "SNC", "OPT", "ATT", "BTR", "REP", "BTC", "RBL", "DLR", "EUR", "CAS",
                        "MOD", "SCP", "FGP", "STK", "ARP", "HLM", "BPK", "PNT", "ZON", "TIM", "TAC",
                        "CMP", "CPM", "RTE", "DST", "MAP", "KYS", "GDE", "STR", "TPS", "GMP", "AKM",
                        "PMC", "USE", "BEA", "RAI", "SCA", "M4A", "SKS", "MP5", "AKS", "VEP",
                        "SVD", "MP7", "ASV", "SA5", "AK4", "AK1", "AK0", "M1A", "MPX", "MP9",
                        "KED", "ADA", "VSS", "VAL", "SR2", "RSA", "HK4", "HK7", "MP1", "M87", "MP3",
                        "TOZ", "KIB", "EME", "GOS", "IDE", "OLI", "ULT", "RES", "SHO", "CUS",
                        "FAC", "LAB", "WOO", "SNI", "SCA", "RAI", "CHE", "BRE", "TAR",
                        "BEA", "SUR", "RUB", "EXF", "RAI", "TUS", "MED", "AMM", "GEA",
                        "TAC", "FIR", "EXT", "RAI", "LOO", "SKI", "THE", "PRA", "FEN",
                        "MEC", "RAG", "JAE", "KAP", "MAR", "KEY", "SHT", "GLU", "KIL",
                        "SAN", "RAV", "BEA", "RAT", "GAM", "SCA", "TRE", "STA", "SAF",
                        "TAC", "SHE", "BAT", "FAQ", "CEO", "USA", "ATM", "HIV", "NBA", "GPS", "UFO",
                        "CPU", "VPN", "4VK",
                        "DOG", "CAT", "CAR", "SUN", "RUN", "HAT", "BOX", "TOY", "PEN", "LEG",
                        "FBI", "CIA", "NSA", "ATF", "DEA", "IRS", "ICE", "DHS"};

                String randomNick = "";
                Random random = new Random();

                if(threeRadioButton.isChecked()){
                    numbersCheckBox.setChecked(false);
                    randomNick = keywords3[random.nextInt(keywords3.length)];
                }
                else if(anyRadioButton.isChecked()){
                    randomNick = generateRandomNickname(uniqueKeywordsEN, random);
                }
                else if(anyRadioButton.isChecked() && translitCheckBox.isChecked()){
                    randomNick = generateRandomNickname(uniqueKeywordsRU, random);
                }



                nickEditText.setText(randomNick);
            }
        });

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = nickEditText.getText().toString();
                if (!nickname.isEmpty()) {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("nickname", nickname);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Никнейм скопирован", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Сгенерируйте никнейм", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String generateRandomNickname(ArrayList<String> keywords, Random random) {
        String keyword = keywords.get(random.nextInt(keywords.size()));

        String[] prefixes = {"Un", "Re", "Pre", "Dis", "Mis", "En", "Ex", "In", "Im",
                "Non", "Over", "Under", "Sub", "Super", "Inter", "Anti", "Auto",
                "Bi", "Co", "De", "Extra", "Fore", "Hyper", "Mega", "Micro", "Mini",
                "Multi", "Out", "Post", "Tri"};

        String[] suffixes = {"able", "al", "en", "ful", "ic", "ive", "less", "ly", "ous", "y",
                "er", "est", "ing", "ed"};

        ArrayList<String> secondWord = new ArrayList<>();
        Collections.addAll(secondWord, "Pro", "Player", "Shadow", "Reaper", "Ghost", "Viper", "Havoc", "Sentinel",
                "Ravage", "Sniper", "Mercenary", "Bandit", "Outlaw", "Rogue", "Saboteur", "Wraith",
                "Warlock", "Enigma", "Vanguard", "Nemesis", "Blitz", "Stryker", "Fury", "Venom", "Hazard",
                "Hunter", "Scorpion", "Phantom", "Spectre", "Titan", "Juggernaut", "Commando",
                "Maverick", "Warlord", "Desperado", "Marksman", "Tactician", "Sentinel", "Sniper", "Tracker",
                "Recon", "Ronin", "Executioner", "Annihilator", "Punisher", "Merciless", "Vengeance", "Rampage",
                "Havoc", "Ravager", "Savage", "Dominator", "Vendetta", "Shadowblade", "Gunslinger", "Shredder",
                "Bulletstorm", "Warpath", "Bruiser", "Berserker", "Demolisher", "Grenadier", "Saboteur", "Infiltrator",
                "Saber", "Warcry", "Thunder", "Storm", "Cyclone", "Tempest", "Avalanche", "Blizzard", "Frostbite",
                "Inferno", "Wildfire", "Phoenix", "Serpent", "Cobra", "Raptor", "Falcon", "Wolf", "Vulture", "Bear",
                "USEC", "Panther", "Lion", "Tiger", "Rhino", "Dragon", "Griffin", "Phoenix", "Hydra", "Chimera",
                "Leviathan", "Kraken", "Reaper", "Specter", "Phantom", "Wraith", "Nightmare", "PRO",
                "Warrior", "Ninja", "Sniper", "Gamer", "Legend", "Master", "Champion", "Hero", "Assassin", "Hunter",
                "Ghost", "Spartan", "Samurai", "Phantom", "Joker", "Reaper", "Cyborg", "Pirate", "Commando",
                "Savior", "Avenger", "Guardian", "Gladiator", "Mercenary", "Ranger", "Viper", "Destroyer",
                "Enforcer", "Nomad", "Prophet", "Outlaw", "Brawler", "Savage",
                "Sneak", "Sniper", "Sharpshooter", "Gunslinger", "Marksman", "Blade",
                "Knight", "Crusader", "Berserker", "Viking", "Rogue", "Thief", "Bandit", "Scout",
                "Pioneer", "Survivor", "Captain", "Commander", "Leader",
                "Strategist", "Tactician", "Engineer", "Scientist", "Inventor",
                "Designer", "Creator", "Builder", "Pilot", "Navigator", "Driver", "Rider",
                "Juggernaut", "Tank", "Bruiser", "Bouncer", "Crusher", "Slayer", "Executor", "Annihilator", "Conqueror",
                "Artifact", "Mutant", "Stalker", "Anomaly", "Pripyat", "Pseudodog", "Monolith", "Thunder", "Radiation",
                "ClearSky", "Barguzin", "Needle", "Chernobyl", "FrostyPeak", "Freedom", "Duty", "Operation", "Arsenal", "Storm",
                "Radar", "Bear", "Pripyat", "Abandoned", "MarkedOne", "Bloodsucker", "Lazarus",
                "Warrior", "Bandit", "RadioTower", "Chernobylite", "Hydroponics", "Strelok", "Lull", "Bear", "Factory", "Cleansing",
                "Pripyat", "Army", "Death", "Chernobylite", "Special", "Monolith", "Storm", "Zonal", "Bar", "Chernobylite", "Sky",
                "Catastrophe", "Pseudogiant", "Laser", "Purity", "Freedom", "Squad", "Pripyat", "Fire", "Mutant", "Zone",
                "Radiation", "Anomaly", "Stalker", "Artifact", "Bar", "Monolith", "Pripyat", "Storm", "Radar", "Chernobyl", "Defender");
        ArrayList<String> uniqueSecondWord = secondWord.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

        StringBuilder replacedKeyword = new StringBuilder();

        if (numbersCheckBox.isChecked()) {
            Map<Character, Character> letterToNumberMap = new HashMap<>();
            letterToNumberMap.put('A', '4');
            letterToNumberMap.put('B', '8');
            letterToNumberMap.put('E', '3');
            letterToNumberMap.put('I', '1');
            letterToNumberMap.put('L', '1');
            letterToNumberMap.put('O', '0');

            int replacements = 0;
            for (char c : keyword.toCharArray()) {
                if (replacements < 2 && random.nextBoolean()) {
                    Character replacement = letterToNumberMap.get(Character.toUpperCase(c));
                    if (replacement != null) {
                        replacedKeyword.append(replacement);
                        replacements++;
                        continue;
                    }
                }
                replacedKeyword.append(c);
            }
        } else {
            replacedKeyword.append(keyword);
        }

        String randomNickname = "";
        String selectedPreset = "";
        if (anyRadioButton.isChecked()) {
            if (translitCheckBox.isChecked()) {
                // код для генерации никнейма на основе uniqueKeywordsRU
            }
            else {
                // код для генерации никнейма на основе uniqueKeywordsEN
            }
        }
        if (anyRadioButton.isChecked() || (anyRadioButton.isChecked() && translitCheckBox.isChecked())) {
            String suffix = suffixes[random.nextInt(suffixes.length)];
            String prefix = prefixes[random.nextInt(prefixes.length)];
            String secWord = uniqueSecondWord.get(random.nextInt(uniqueSecondWord.size()));
            ;

            String[] presets = {
                    prefix + replacedKeyword,
                    replacedKeyword + suffix,
                    prefix + replacedKeyword + suffix,
                    replacedKeyword + secWord,
                    prefix + replacedKeyword + secWord,
                    prefix + replacedKeyword + "_" + secWord,
                    prefix + replacedKeyword + "-" + secWord,
                    replacedKeyword + secWord + suffix,
                    replacedKeyword + "_" + secWord + suffix,
                    replacedKeyword + "-" + secWord + suffix,
            };

            randomNickname = presets[random.nextInt(presets.length)];
            selectedPreset = randomNickname;

            int maxAttempts = 10;
            int attempts = 0;
            while (selectedPreset.length() > 15 && attempts < maxAttempts) {
                if (selectedPreset.contains(secWord)) {
                    if ((suffix.length() + prefix.length()) < secWord.length()) {
                        if (selectedPreset.contains("-") || selectedPreset.contains("_")) {
                            selectedPreset = selectedPreset.replaceFirst("-" + secWord, "");
                            selectedPreset = selectedPreset.replaceFirst("_" + secWord, "");
                            if (!selectedPreset.contains(suffix)) {
                                selectedPreset += suffix;
                            } else if (!selectedPreset.contains(prefix)) {
                                selectedPreset = prefix + selectedPreset;
                            }
                        } else {
                            selectedPreset = selectedPreset.replaceFirst(secWord, "");
                            selectedPreset = selectedPreset.replaceFirst(secWord, "");
                            if (!selectedPreset.contains(suffix)) {
                                selectedPreset += suffix;
                            } else if (!selectedPreset.contains(prefix)) {
                                selectedPreset = prefix + selectedPreset;
                            }
                        }
                    } else if ((suffix.length() + prefix.length()) >= secWord.length()) {
                        selectedPreset = selectedPreset.replaceFirst(suffix, "");
                        selectedPreset = selectedPreset.replaceFirst(prefix, "");
                        if(selectedPreset.length() > 15){
                            selectedPreset = selectedPreset.replaceFirst(secWord, "");
                            selectedPreset += suffix;
                            selectedPreset = prefix + selectedPreset;
                        }
                    }

                    Log.d("Preset", "preset: " + selectedPreset);
                    Log.d("Length", "secWord_TRUE: " + secWord.length() + secWord);
                    Log.d("Length", "suffix: " + suffix.length() + suffix);
                    Log.d("Length", "prefix: " + prefix.length() + prefix);
                    Log.d("Length", "---------");
                }
                else {
                    if (!selectedPreset.contains(suffix)) {
                        selectedPreset += suffix;
                    }
                    else if (!selectedPreset.contains(prefix)) {
                        selectedPreset = prefix + selectedPreset;
                    }

                    if(selectedPreset.length() > 15){
                        if(suffix.length() > prefix.length()){
                            selectedPreset = selectedPreset.replaceFirst(suffix, "");
                        }
                        else selectedPreset = selectedPreset.replaceFirst(prefix, "");
                        if(selectedPreset.length() > 15){
                            if (selectedPreset.contains(suffix)) {
                                selectedPreset = selectedPreset.replaceFirst(suffix, "");
                            }
                            else selectedPreset = selectedPreset.replaceFirst(prefix, "");
                        }
                    }

                    Log.d("Preset", "preset: " + selectedPreset);
                    Log.d("Length", "secWord_FALSE: " + secWord.length() + secWord);
                    Log.d("Length", "suffix: " + suffix.length() + suffix);
                    Log.d("Length", "prefix: " + prefix.length() + prefix);
                    Log.d("Length", "---------");
                }
                attempts++;
            }
            if (selectedPreset.length() > 15 || selectedPreset.length() < 3) {
                Toast.makeText(MainActivity.this, "Генератор задумался. Попробуйте ещё раз", Toast.LENGTH_SHORT).show();
                //randomNickname = "-";
            }
        }
        return selectedPreset;
    }

}
