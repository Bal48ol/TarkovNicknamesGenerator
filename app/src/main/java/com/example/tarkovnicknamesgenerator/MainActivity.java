package com.example.tarkovnicknamesgenerator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.bumptech.glide.Glide;
import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdEventListener;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.common.InitializationListener;
import com.yandex.mobile.ads.common.MobileAds;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    private EditText nickEditText;
    private Button nickButton;
    private Button copyButton;
    private RadioButton threeRadioButton;
    private RadioButton anyRadioButton;
    private CheckBox numbersCheckBox;
    private CheckBox translitCheckBox;
    private GifImageView gifImageView1;
    private GifImageView gifImageView2;
    private GifImageView gifImageView3;
    private GifImageView gifImageView4;
    private GifImageView gifImageView5;
    private GifImageView gifImageView6;
    private GifImageView gifImageView7;
    private GifImageView gifImageView8;
    private EditText escapeEditText;
    private Button escapeButton;
    private LinearLayout mainLinearLayout;
    private Button skipButton;
    private Button rustoreButton;
    private BannerAdView mBannerAdView;
    private BannerAdView mBannerAdView2;
    private View viewView2;
    private TextView errorTextView;
    private TextView gybkTextView;
    private static final String YANDEX_MOBILE_ADS_TAG = "YandexMobileAds";

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
        escapeEditText = findViewById(R.id.escapeEditText);
        escapeButton = findViewById(R.id.escapeButton);
        gifImageView1 = findViewById(R.id.gifImageView1);
        gifImageView2 = findViewById(R.id.gifImageView2);
        gifImageView3 = findViewById(R.id.gifImageView3);
        gifImageView4 = findViewById(R.id.gifImageView4);
        gifImageView5 = findViewById(R.id.gifImageView5);
        gifImageView6 = findViewById(R.id.gifImageView6);
        gifImageView7 = findViewById(R.id.gifImageView7);
        gifImageView8 = findViewById(R.id.gifImageView8);
        mainLinearLayout = findViewById(R.id.mainLinearLayout);
        viewView2 = findViewById(R.id.viewView2);
        errorTextView = findViewById(R.id.errorTextView);
        gybkTextView = findViewById(R.id.gybkTextView);

        Glide.with(this)
                .asGif()
                .load(R.drawable.gif1)
                .into(gifImageView1);
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif2)
                .into(gifImageView2);
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif3)
                .into(gifImageView3);
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif4)
                .into(gifImageView4);
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif5)
                .into(gifImageView5);
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif6)
                .into(gifImageView6);
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif7)
                .into(gifImageView7);
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif8)
                .into(gifImageView8);


        AnimationDrawable animationDrawable = (AnimationDrawable) mainLinearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        showInstructionDialog();

        anyRadioButton.setChecked(true);

        MobileAds.initialize(this, new InitializationListener() {
            @Override
            public void onInitializationCompleted() {
                Log.d(YANDEX_MOBILE_ADS_TAG, "SDK initialized");
            }
        });

        // Создание экземпляра mAdView.
        mBannerAdView = (BannerAdView) findViewById(R.id.banner_ad_view);
        String AdUnitId = "R-M-2699211-1";
        mBannerAdView.setAdUnitId(AdUnitId);
        mBannerAdView.setAdSize(AdSize.BANNER_320x50);

        // Создание объекта таргетирования рекламы.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Загрузка объявления.
        mBannerAdView.loadAd(adRequest);

        // Создание экземпляра mAdView. demo-banner-yandex
        mBannerAdView2 = (BannerAdView) findViewById(R.id.banner_ad_view2);
        String AdUnitId2 = "R-M-2699211-2"; //R-M-2699211-2
        mBannerAdView2.setAdUnitId(AdUnitId2);
        mBannerAdView2.setAdSize(AdSize.BANNER_320x50);

        // Создание объекта таргетирования рекламы.
        AdRequest adRequest2 = new AdRequest.Builder().build();

        // Загрузка объявления.
        mBannerAdView2.loadAd(adRequest2);

        String nickname = nickEditText.getText().toString();
        if (nickname.isEmpty()){
            nickEditText.setText("Меня зовут...");
        }

        nickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(nickButton);
                ArrayList<String> keywordsEN = new ArrayList<>();
                Collections.addAll(keywordsEN, "Escape", "Tarkov", "Survival", "Shooter", "Military", "PMC",
                        "Raid", "Loot", "Scav", "BattleState", "Gear", "Weapon", "Armor", "Ammo",
                        "Quest", "Custom", "Factory", "Meta",
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
                        "RPK", "SKS", "Roubles", "Rubles", "BEAR", "USEC",
                        "AK74", "M4", "ASVAL", "SKS45", "GPhone",
                        "Armor", "MedKit", "Split", "IFAK", "CMS", "Gold",
                        "CPU", "PSU", "SSD", "HDD", "RAM", "5x45", "7x62", "5x56", "9x19",
                        "Raids", "Loot", "Custom",
                        "Reserve", "Factory", "Ammo", "Armor", "Meds", "Extract", "AKM",
                        "M4A1", "SA58", "ASVAL", "Sniper", "Scope", "Raider", "Shturm", "RPK",
                        "SKS", "Roubles", "Rubles", "Raid", "Gear",
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
                        "Vepr", "SKS", "Bear", "USEC", "Grizzly",
                        "AK74", "M4", "ASVAL", "SKS45", "Ammo",
                        "Armor", "Med", "Kit", "Split", "IFAK", "Morphi", "Gold",
                        "CPU", "SSD", "HDD", "GPU", "M995", "BS", "BT", "BP",
                        "T45M", "VPO", "AKSU", "AKM", "PMC", "Raids", "Loot",
                        "Reserve", "Factory", "Ammo", "Armor", "Meds", "Extract", "AKM",
                        "M4A1", "SA58", "ASVAL", "Sniper", "Scope", "Raider", "Killa",
                        "SKS", "Roubles", "Rubles", "Bear", "USEC", "Raid", "Gear",
                        "PMC", "SVD", "AK74", "M1A", "RSASS", "MP7",
                        "AKS", "Saiga", "VSS", "VAL", "M9", "MPX", "PP-19", "P-90", "Glock", "Mak", "TT",
                        "TT", "Grach", "APS", "APB", "MP443", "LedX", "RGO", "RGN", "VOG",
                        "PMCex", "Raid", "Loot", "Labs", "Woods", "Ammo",
                        "Armor", "Meds", "AKM", "M4A1", "SA58", "ASVAL", "Scope", "Tagilla",
                        "SKS", "Bear", "USEC", "AK74", "M4", "UN", "Tourist",
                        "ASVAL", "SKS45", "TOZ-106", "Streets", "Oli", "Idea",
                        "Armor", "Med", "Kit", "Split", "IFAK", "CMS", "Gold", "VPO", "RPK", "Toxic",
                        "Prapor", "Therapist", "Fence", "Skier", "Peacekeeper", "Mechanic", "Ragman", "Jaeger",
                        "Cheh", "Box200", "Box300", "Boxer", "Zinc", "Souls", "Fubar", "Salewa",
                        "Chiter", "AxeMan", "Mosiner", "AKSU", "MR-133", "NATO", "NatoAK", "Riji",
                        "Lemon", "Trofy", "FullGear", "Recumbent", "PreFire", "Tap", "OneShot", "Vendor",
                        "Nikita", "Geneburn", "Trainfender", "Bread", "DogHome", "Gozan", "Ulach", "Goshan");

                ArrayList<String> uniqueKeywordsEN = keywordsEN.stream()
                        .distinct()
                        //.map(MainActivity::removeLastVowel)
                        .collect(Collectors.toCollection(ArrayList::new));

                ArrayList<String> keywordsRU = new ArrayList<>();
                Collections.addAll(keywordsRU, "Pobeg", "Tarkov", "Vyzhivach", "Shuter", "Voennyi",
                        "CHVK", "Reid", "Dobycha", "Dikiy", "BattleState", "Snaryga", "Oruzhie", "Bronya",
                        "Patrony", "Zadanie", "Kastom", "Fabrika", "Laba", "Ubezhka", "Treider",
                        "Rynok", "Bezopasnyi", "Konteiner", "Yashchik", "Zdorove", "Stamina", "Navyk",
                        "Uroven", "PVP", "PVE", "Tima", "Taktikulni", "Realizm", "Toxic", "Turist",
                        "Hardkor", "Ukrytie", "Skrytnost", "Granata", "Pripasy", "Meta",
                        "Pomoshch", "Bint", "Obezbol", "Ryukzak", "SHlem", "Nochnik", "RGO", "RGN", "VOG",
                        "Glushak", "Optika", "Barter", "Repa", "Bitkoin", "Rubl", "Grizzly",
                        "Dollar", "Evro", "Modding", "Pricel", "Priklad", "Plastina", "GPhone",
                        "Shlem", "Tochka", "Zona", "Vremya", "Taktika", "Kemping", "Kemper", "Lager", "Distanciya",
                        "Karta", "Klyuch", "Rukovodstvo", "Strategiya", "Sovet", "GamePlay", "Reid", "Dobycha",
                        "Patron", "Mosinka", "Bronya", "Medikamenty", "AKM", "M4A1", "SA58", "ASVAL", "Pricel",
                        "RPK", "SKS", "Rubli", "Rubli", "IFAK", "CMS", "Zoloto", "CPU",
                        "BP", "SSD", "HDD", "Viduha", "5x45", "7x62", "5x56", "9x19", "Dobycha",
                        "Tamozhnya", "Zavod", "Rezerv", "Razvyazka", "Bereg", "Les", "Ulicy",
                         "Patrony", "Bronya", "AKM", "M4A1",
                        "SA58", "ASVAL", "Snaiper", "Pricel", "Reider", "Shturm", "RPK", "SKS", "Rubli",
                        "BEAR", "Medved", "USEC", "AK74", "M4", "ASVAL", "SKS45", "Bronya", "MedNabor",
                        "IFAK", "CMS", "Zoloto", "CPU", "SSD", "OZU", "M995", "BS", "Oli", "Goshan", "Idea",
                        "BT", "BP", "T45M", "VPO", "AKSU", "AKM", "CHVK", "Dobycha",
                        "Pricel", "Reider", "Killa", "SKS", "Rubli", "Chupik",
                        "CHVK", "SVD", "AK74", "M1A", "SKS", "RSASS", "M700",
                        "MP5", "AKS", "AKMS", "Saiga", "VSS", "VAL", "M9", "MPX", "PP-19", "P90", "Glock", "Makarov",
                        "TT", "Grach", "APS", "APB", "MP443", "Killa", "Reshala", "Sanitar", "Gluhar", "Shturman",
                        "Kult", "Tagila", "Snaiper", "Boss", "Torgovec", "Naemnik", "Zhulik", "Nomad", "Otshelnik",
                        "Prizrak", "Stalker", "Zhnec", "Hishchnik", "Sabotazhnik", "Ohotnik",
                        "Ispolnitel", "Vandal", "Maroder", "Bandit", "Leduha",
                        "VneZakona", "Reider", "Naemnik", "Strelok", "Lezvie", "Berserk", "Viking",
                        "Razboinik", "Vor", "Bandit", "Skaut", "Kapitan", "Komandir",
                        "Lider", "Strateg", "Taktik", "Inzhener", "Uchenyi", "Pilot", "Navigator", "Voditel",
                        "Prapor", "Terapevt", "Skupshchik", "Lyzhnik", "Mirotvorec", "Mekhanik", "Baraholshchik", "Eger",
                        "Vsadnik", "Tank", "Vyshibala", "Drobilka", "Ubijca", "Ispolnitel", "Annigilyator",
                        "Pokoritel", "Plut", "Reid", "Dobycha", "Les", "Patrony", "Bronya", "Mosin", "AKM", "M4A1",
                        "SA58", "ASVAL", "Pricel", "Killa", "Vepr", "SKS", "Medved", "USEC", "AK74", "M4", "ASVAL", "SKS45",
                        "Patrony", "Bronya", "Medicina", "Nabor", "Razdelenie", "IFAK", "Morfij", "Zoloto", "CPU", "SSD",
                        "OZU", "M995", "BS", "BT", "BP", "T45M", "VPO", "AKSU", "AKM", "CHVK", "Truba", "Sapog",
                        "Dobycha", "Les", "Patrony", "Bronya", "AKM", "M4A1", "SA58", "ASVAL",
                        "Tagila", "SKS", "Medved", "USEC", "AK74", "M4", "ASVAL", "SKS45", "Tozik", "Bronya", "Riji",
                        "Medicina", "Nabor", "IFAK", "CMS", "Zoloto", "VPO", "RPK", "Gruz200", "OOH",
                        "Gruz300", "Bokser", "Cheh", "Duh", "Fubar", "Salewa", "Chiter", "Toporist", "Mosinist", "Berci",
                        "Ksyuha", "Dashka", "Murka", "Dikij", "CHVK", "NATO", "NatoAK", "Limonka", "Trofei", "Fulka", "Polezhaikin",
                        "Prifaer", "Tap", "VanShot", "Torgovec", "Nikita", "Baton", "Budka", "Geneburn", "Gozan", "Ulach", "Goshan");

                ArrayList<String> uniqueKeywordsRU = keywordsRU.stream()
                        .distinct()
                        //.map(MainActivity::removeLastVowel)
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

                if (anyRadioButton.isChecked() && translitCheckBox.isChecked()) {
                    gybkTextView.setVisibility(View.VISIBLE);
                    errorTextView.setVisibility(View.GONE);
                    numbersCheckBox.setVisibility(View.VISIBLE);
                    viewView2.setVisibility(View.VISIBLE);
                    translitCheckBox.setVisibility(View.VISIBLE);
                    randomNick = generateRandomNickname(uniqueKeywordsRU, random);
                }
                else if (anyRadioButton.isChecked()) {
                    gybkTextView.setVisibility(View.VISIBLE);
                    errorTextView.setVisibility(View.GONE);
                    numbersCheckBox.setVisibility(View.VISIBLE);
                    viewView2.setVisibility(View.VISIBLE);
                    translitCheckBox.setVisibility(View.VISIBLE);
                    randomNick = generateRandomNickname(uniqueKeywordsEN, random);
                }
                else if (threeRadioButton.isChecked()) {
                    gybkTextView.setVisibility(View.GONE);
                    viewView2.setVisibility(View.GONE);
                    errorTextView.setVisibility(View.VISIBLE);
                    numbersCheckBox.setChecked(false);
                    numbersCheckBox.setVisibility(View.GONE);
                    translitCheckBox.setChecked(false);
                    translitCheckBox.setVisibility(View.GONE);
                    randomNick = keywords3[random.nextInt(keywords3.length)];
                }
                nickEditText.setText(randomNick);
            }
        });

        escapeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(escapeButton);
                 String[] phrasesIfNotEscape = {
                        "Жди гранаты в свою комнату!",
                        "Ты думаешь, что Тарков отпустит тебя? Забудь!",
                        "Здесь нет выхода, только смерть и патроны.",
                        "Попытайся сбежать, и тебя закемпят на выходе.",
                        "Эй, ты! Забудь о свободе, здесь ты навсегда!",
                        "Тарков - это ловушка для слабых.",
                        "Сбежать невозможно, как и вынести танковый аккум на 1 уровне.",
                        "Ты можешь попытаться сбежать, но Тарков всегда найдет тебя.",
                         "Ты поймаешь маслину от дикого."
                };

                String[] phrasesIfEscape = {
                        "Сегодня ты сможешь сбежать из Таркова!",
                        "Тебе выпал шанс выжить и покинуть Тарков!",
                        "Сегодня ты сможешь покинуть Тарков и спастись!",
                        "Cегодня ты оставишь Тарков навсегда позади!",
                        "Сегодня ты освободишься от Таркова и начнёшь новую жизнь!",
                        "Твоя удача повернулась к тебе - ты свободен!",
                        "Сегодня ты перебьёшь всех чвк + диких",
                        "Не сомневайся, сегодня ты сможешь сбежать из Таркова!",
                        "Ты сможешь преодолеть все испытания и покинуть Тарков!",
                        "Сегодня ты сможешь сделать невозможное - сбежать из Таркова!"
                };

                String escapeQuest = "";
                Random random = new Random();
                int escapeResult = random.nextInt(8); // Генерируем случайное значение 0 или 1

                if (escapeResult == 0) {
                    gifImageView2.setVisibility(View.GONE);
                    gifImageView3.setVisibility(View.GONE);
                    gifImageView4.setVisibility(View.GONE);
                    gifImageView5.setVisibility(View.GONE);
                    gifImageView6.setVisibility(View.GONE);
                    gifImageView7.setVisibility(View.GONE);
                    gifImageView8.setVisibility(View.GONE);
                    escapeQuest = phrasesIfNotEscape[random.nextInt(phrasesIfNotEscape.length)];
                    gifImageView1.setVisibility(View.VISIBLE);
                }
                else if (escapeResult == 1) {
                    gifImageView1.setVisibility(View.GONE);
                    gifImageView3.setVisibility(View.GONE);
                    gifImageView4.setVisibility(View.GONE);
                    gifImageView5.setVisibility(View.GONE);
                    gifImageView6.setVisibility(View.GONE);
                    gifImageView7.setVisibility(View.GONE);
                    gifImageView8.setVisibility(View.GONE);
                    escapeQuest = phrasesIfNotEscape[random.nextInt(phrasesIfNotEscape.length)];
                    gifImageView2.setVisibility(View.VISIBLE);
                }
                else if (escapeResult == 2) {
                    gifImageView1.setVisibility(View.GONE);
                    gifImageView2.setVisibility(View.GONE);
                    gifImageView4.setVisibility(View.GONE);
                    gifImageView5.setVisibility(View.GONE);
                    gifImageView6.setVisibility(View.GONE);
                    gifImageView7.setVisibility(View.GONE);
                    gifImageView8.setVisibility(View.GONE);
                    escapeQuest = phrasesIfNotEscape[random.nextInt(phrasesIfNotEscape.length)];
                    gifImageView3.setVisibility(View.VISIBLE);
                }
                else if (escapeResult == 3) {
                    gifImageView1.setVisibility(View.GONE);
                    gifImageView3.setVisibility(View.GONE);
                    gifImageView4.setVisibility(View.GONE);
                    gifImageView5.setVisibility(View.GONE);
                    gifImageView2.setVisibility(View.GONE);
                    gifImageView7.setVisibility(View.GONE);
                    gifImageView8.setVisibility(View.GONE);
                    escapeQuest = phrasesIfNotEscape[random.nextInt(phrasesIfNotEscape.length)];
                    gifImageView6.setVisibility(View.VISIBLE);
                }
                else if (escapeResult == 4) {
                    gifImageView1.setVisibility(View.GONE);
                    gifImageView3.setVisibility(View.GONE);
                    gifImageView2.setVisibility(View.GONE);
                    gifImageView5.setVisibility(View.GONE);
                    gifImageView6.setVisibility(View.GONE);
                    gifImageView7.setVisibility(View.GONE);
                    gifImageView8.setVisibility(View.GONE);
                    escapeQuest = phrasesIfEscape[random.nextInt(phrasesIfEscape.length)];
                    gifImageView4.setVisibility(View.VISIBLE);
                }
                else if (escapeResult == 5) {
                    gifImageView1.setVisibility(View.GONE);
                    gifImageView3.setVisibility(View.GONE);
                    gifImageView4.setVisibility(View.GONE);
                    gifImageView2.setVisibility(View.GONE);
                    gifImageView6.setVisibility(View.GONE);
                    gifImageView7.setVisibility(View.GONE);
                    gifImageView8.setVisibility(View.GONE);
                    escapeQuest = phrasesIfEscape[random.nextInt(phrasesIfEscape.length)];
                    gifImageView5.setVisibility(View.VISIBLE);
                }
                else if (escapeResult == 6) {
                    gifImageView1.setVisibility(View.GONE);
                    gifImageView3.setVisibility(View.GONE);
                    gifImageView4.setVisibility(View.GONE);
                    gifImageView5.setVisibility(View.GONE);
                    gifImageView6.setVisibility(View.GONE);
                    gifImageView2.setVisibility(View.GONE);
                    gifImageView8.setVisibility(View.GONE);
                    escapeQuest = phrasesIfEscape[random.nextInt(phrasesIfEscape.length)];
                    gifImageView7.setVisibility(View.VISIBLE);
                }
                else {
                    gifImageView1.setVisibility(View.GONE);
                    gifImageView3.setVisibility(View.GONE);
                    gifImageView4.setVisibility(View.GONE);
                    gifImageView5.setVisibility(View.GONE);
                    gifImageView6.setVisibility(View.GONE);
                    gifImageView7.setVisibility(View.GONE);
                    gifImageView2.setVisibility(View.GONE);
                    escapeQuest = phrasesIfEscape[random.nextInt(phrasesIfEscape.length)];
                    gifImageView8.setVisibility(View.VISIBLE);
                }

                escapeEditText.setText(escapeQuest);
            }
        });

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateClick(copyButton);
                String nickname = nickEditText.getText().toString();
                if (nickname.equals("Меня зовут...")) {
                    Toast.makeText(MainActivity.this, "Сгенерируйте никнейм", Toast.LENGTH_SHORT).show();
                }
                else {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("nickname", nickname);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Никнейм " + nickname + " скопирован", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private String generateRandomNickname(ArrayList<String> keywords, Random random) {
        String keyword = keywords.get(random.nextInt(keywords.size()));

        String[] prefixesEN = {"Un", "Re", "Pre", "Dis", "Mis", "En", "Ex", "In", "Im",
                "Non", "Over", "Under", "Sub", "Super", "Inter", "Anti", "Auto",
                "Bi", "Co", "De", "Extra", "Fore", "Hyper", "Mega", "Micro", "Mini",
                "Multi", "Out", "Post", "Tri", "Grand"};

        String[] prefixesRU = {"Pri", "Ne", "Za", "Vse", "Super", "Mega", "Maksi", "Ultra", "Top",
                "Eks", "Giper", "Anti", "Bez", "Super", "Veliko", "Malo", "Chudo"};

        String[] suffixesEN = {"able", "al", "en", "ful", "ic", "ive", "less", "ly", "ous", "y",
                "er", "est", "ing", "ed"};

        String[] suffixesRU = {"li", "ov", "ik", "er", "ych", "un", "en", "ec", "on", "ar",
                "an", "in", "ysh", "iks", "el", "ec", "oza", "un"};

        ArrayList<String> secondWordEN = new ArrayList<>();
        Collections.addAll(secondWordEN, "Pro", "Player", "Shadow", "Reaper", "Ghost", "Viper", "Havoc", "Sentinel",
                "Ravage", "Sniper", "Mercenary", "Bandit", "Outlaw", "Rogue", "Saboteur", "Wraith", "Killer",
                "Warlock", "Enigma", "Vanguard", "Nemesis", "Blitz", "Stryker", "Fury", "Venom", "Hazard",
                "Hunter", "Scorpion", "Phantom", "Spectre", "Titan", "Juggernaut", "Commando", "Mainer",
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
                "Pioneer", "Survivor", "Captain", "Commander", "Leader", "Owner",
                "Strategist", "Tactician", "Engineer", "Scientist", "Inventor",
                "Designer", "Creator", "Builder", "Pilot", "Navigator", "Driver", "Rider",
                "Juggernaut", "Tank", "Bruiser", "Bouncer", "Crusher", "Slayer", "Executor", "Annihilator", "Conqueror",
                "Artifact", "Mutant", "Stalker", "Anomaly", "Pripyat", "Pseudodog", "Monolith", "Thunder", "Radiation",
                "ClearSky", "Barguzin", "Needle", "Chernobyl", "FrostyPeak", "Freedom", "Duty", "Operation", "Arsenal", "Storm",
                "Radar", "Bear", "Pripyat", "Abandoned", "MarkedOne", "Bloodsucker", "Lazarus",
                "Warrior", "Bandit", "RadioTower", "Hydroponics", "Strelok", "Lull", "Bear", "Factory", "Cleansing",
                "Pripyat", "Army", "Death", "Special", "Monolith", "Storm", "Zonal", "Bar", "Sky",
                "Catastrophe", "Pseudogiant", "Laser", "Purity", "Freedom", "Squad", "Pripyat", "Fire", "Mutant", "Zone",
                "Radiation", "Anomaly", "Stalker", "Artifact", "Bar", "Monolith", "Pripyat", "Storm", "Radar", "Defender");
        ArrayList<String> uniqueSecondWordEN = secondWordEN.stream()
                .distinct()
                .map(MainActivity::removeLastVowel)
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> secondWordRU = new ArrayList<>();
        Collections.addAll(secondWordRU, "Proshka", "Igrok", "Ten", "Prizrak", "Gadyuka", "Haos",
                "Strazh", "Razorenie", "Snajper", "Nayomnik", "Bandit", "VneZakona", "Izgoi", "Sabotazh",
                "Prizrak", "Koldun", "Zagadka", "Avangard", "Vrag", "Blic", "Straiker", "Yarost", "Yad", "Opasnost",
                "Ohotnik", "Skorpion", "Fantom", "Prizrak", "Titan", "Dzhager", "Komandos", "Maverik", "Nachalnik",
                "Otchayan", "Metkij", "Taktik", "Ohotnik", "Razvedchik", "Ronin", "Palach", "Karatel",
                "Bezzhalosti", "Mest", "Buistvo", "Haos", "Razoritel", "Dikar", "Dominator", "Mest", "Klinok",
                "Pistoleter", "Izmelchitel", "Shtorm", "Grubiyan", "Berserk", "Razrushitel", "Killer",
                "Grenader", "Sabotazhnik", "Sablya", "Klich", "Grom", "Shtorm", "Ciklon", "Mainer", "Owner",
                "Burya", "Lavina", "Metel", "Inferno", "Pozhar", "Feniks", "Zmei", "Kobra",
                "Hishchnik", "Sokol", "Volk", "Stervyatnik", "Medved", "USEK", "Pantera", "Lev", "Tigr", "Nosorog",
                "Drakon", "Grifon", "Feniks", "Gidra", "Himera", "Leviafan", "Kraken", "Zhnec", "Prizrak", "Fantom",
                "Koshmar", "Profi", "Voin", "Nindzya", "Snaiper", "Geimer", "Legenda", "Master",
                "Chempion", "Geroi", "Ubiica", "Ohotnik", "Prizrak", "Spartanec", "Samurai", "Fantom", "Dzhoker",
                "Kiborg", "Pirat", "Kommandos", "Spasitel", "Mstitel", "Strazh", "Gladiator", "Nayomnik",
                "Gadyuka", "Razrushitel", "Ispolnitel", "Kochevnik", "Prorok", "Drachun",
                "Dikar", "Strelok", "Pistoleter", "Klinok",
                "Krestonosec", "Berserk", "Viking", "Izgoi", "Vor", "Bandit", "Razvedchik", "Pioner", "Vyzhivshij",
                "Kapitan", "Komandir", "Lider", "Strateg", "Taktik", "Inzhener", "Pilot", "Navigator", "Voditel", "Vsadnik",
                "Dzhaggernaut", "Tank", "Grubiyan",
                "Vyshibala", "Drobilshik", "Ubijca", "Ispolnitel", "Zavoevatel", "Artefakt", "Mutant",
                "Stalker", "Anomaliya", "Pripyat", "Psevdopes", "Monolit", "Grom", "Radiaciya", "ChistoeNebo",
                "Igla", "Chernobyl", "Svoboda", "Dolg", "Operaciya", "Arsenal", "Shtorm", "Radar", "Medved",
                "Pripyat", "Zabroshka", "Krovosos", "Lazar", "Voin", "Bandit",
                "Gidroponika", "Zatishe", "Medved", "Zavod", "Pripyat", "Smert",
                "Monolit", "Shtorm", "Zonalnyi", "Bar", "Nebo", "Katastrofa", "Lazer",
                "Svoboda", "Komanda", "Pripyat", "Ogon", "Mutant", "Zona", "Radiaciya", "Anomaliya", "Stalker", "Artefakt",
                "Bar", "Monolit", "Pripyat", "Shtorm", "Radar", "Zashchitnik");
        ArrayList<String> uniqueSecondWordRU = secondWordRU.stream()
                .distinct()
                .map(MainActivity::removeLastVowel)
                .collect(Collectors.toCollection(ArrayList::new));

//        String[] usecArray = {
//                "USEC", "Англоязычные", "Международная", "Контрактники", "Модернизированное",
//                "Высокотехнологичное", "Профессиональные", "Американская", "Специализация",
//                "Тактическая", "Командный", "Специализация", "Высокий",
//                "Связь", "Профессиональные", "Акцент"
//        };
//
//        String[] bearArray = {
//                "BEAR", "Российская", "Русскоязычные", "Военная", "Солдаты", "Стандартное",
//                "Тяжелое", "Профессиональные", "Российская", "Специализация",
//                "Боевая", "Радио", "Специализация", "Высокий",
//                "Изоляция", "Опыт", "Акцент"
//        };

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
        if (anyRadioButton.isChecked() && translitCheckBox.isChecked()) {
            String suffix = suffixesRU[random.nextInt(suffixesRU.length)];
            String prefix = prefixesRU[random.nextInt(prefixesRU.length)];
            String secWord = uniqueSecondWordRU.get(random.nextInt(uniqueSecondWordRU.size()));

            String[] presets = {
                    prefix + replacedKeyword,
                    replacedKeyword + suffix,
                    prefix + replacedKeyword + suffix,
                    replacedKeyword + secWord,
                    prefix + replacedKeyword + secWord,
                    prefix + replacedKeyword + "_" + secWord,
                    prefix + replacedKeyword + "-" + secWord,
                    replacedKeyword + suffix + secWord,
                    replacedKeyword  + suffix + "_" + secWord,
                    replacedKeyword  + suffix + "-" + secWord
            };

            randomNickname = presets[random.nextInt(presets.length)];
            selectedPreset = randomNickname;

            int maxAttempts = 10;
            int attempts = 0;
            while (selectedPreset.length() > 15 && attempts < maxAttempts) {
                if (selectedPreset.contains(secWord)) {
                    if ((suffix.length() + prefix.length()) < secWord.length()) {
                        if (selectedPreset.contains("-" + secWord) || selectedPreset.contains("_" + secWord)) {
                            selectedPreset = selectedPreset.replaceFirst("-" + secWord, "");
                            selectedPreset = selectedPreset.replaceFirst("_" + secWord, "");
                            if (!selectedPreset.contains(suffix)) {
                                selectedPreset += suffix;
                            } else if (!selectedPreset.contains(prefix)) {
                                selectedPreset = prefix + selectedPreset;
                            }
                        }
                        else {
                            selectedPreset = selectedPreset.replaceFirst(secWord, "");
                            if (!selectedPreset.contains(suffix)) {
                                selectedPreset += suffix;
                            } else if (!selectedPreset.contains(prefix)) {
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
                        }
                    }
                    else if ((suffix.length() + prefix.length()) >= secWord.length()) {
                        selectedPreset = selectedPreset.replaceFirst(suffix, "");
                        selectedPreset = selectedPreset.replaceFirst(prefix, "");
                        if(selectedPreset.length() > 15){
                            if (selectedPreset.contains("-" + secWord) || selectedPreset.contains("_" + secWord)) {
                                selectedPreset = selectedPreset.replaceFirst("-" + secWord, "");
                                selectedPreset = selectedPreset.replaceFirst("_" + secWord, "");
                            }
                            else {
                                selectedPreset = selectedPreset.replaceFirst(secWord, "");
                            }
                            selectedPreset += suffix;
                            selectedPreset = prefix + selectedPreset;
                        }

                    }

                    Log.d("Preset", "presetRu: " + selectedPreset);
                    Log.d("Length", "secWord_TRUE: " + secWord.length() + secWord);
                    Log.d("Length", "suffix: " + suffix.length() + suffix);
                    Log.d("Length", "prefix: " + prefix.length() + prefix);
                    Log.d("Length", "---------");
                }
                else {
                    if(selectedPreset.contains("-") || selectedPreset.contains("_")){
                        selectedPreset = selectedPreset.replaceFirst("-", "");
                        selectedPreset = selectedPreset.replaceFirst("_", "");
                    }

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

                    Log.d("Preset", "presetRU: " + selectedPreset);
                    Log.d("Length", "secWord_FALSE: " + secWord.length() + secWord);
                    Log.d("Length", "suffix: " + suffix.length() + suffix);
                    Log.d("Length", "prefix: " + prefix.length() + prefix);
                    Log.d("Length", "---------");
                }
                attempts++;
            }
            if (selectedPreset.length() > 15 || selectedPreset.length() < 3) {
                Toast.makeText(MainActivity.this, "Генератор задумался. Попробуйте ещё раз", Toast.LENGTH_SHORT).show();
                selectedPreset = "Меня зовут...";
            }
        }

        else {
            String suffix = suffixesEN[random.nextInt(suffixesEN.length)];
            String prefix = prefixesEN[random.nextInt(prefixesEN.length)];
            String secWord = uniqueSecondWordEN.get(random.nextInt(uniqueSecondWordEN.size()));

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
                        if (selectedPreset.contains("-" + secWord) || selectedPreset.contains("_" + secWord)) {
                            selectedPreset = selectedPreset.replaceFirst("-" + secWord, "");
                            selectedPreset = selectedPreset.replaceFirst("_" + secWord, "");
                            if (!selectedPreset.contains(suffix)) {
                                selectedPreset += suffix;
                            } else if (!selectedPreset.contains(prefix)) {
                                selectedPreset = prefix + selectedPreset;
                            }
                        } else {
                            selectedPreset = selectedPreset.replaceFirst(secWord, "");
                            if (!selectedPreset.contains(suffix)) {
                                selectedPreset += suffix;
                            } else if (!selectedPreset.contains(prefix)) {
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
                        }
                    }
                    else if ((suffix.length() + prefix.length()) >= secWord.length()) {
                        selectedPreset = selectedPreset.replaceFirst(suffix, "");
                        selectedPreset = selectedPreset.replaceFirst(prefix, "");
                        if(selectedPreset.length() > 15){
                            if (selectedPreset.contains("-" + secWord) || selectedPreset.contains("_" + secWord)) {
                                selectedPreset = selectedPreset.replaceFirst("-" + secWord, "");
                                selectedPreset = selectedPreset.replaceFirst("_" + secWord, "");
                            }
                            else {
                                selectedPreset = selectedPreset.replaceFirst(secWord, "");
                            }
                            selectedPreset += suffix;
                            selectedPreset = prefix + selectedPreset;
                        }
                    }

                    Log.d("Preset", "presetEN: " + selectedPreset);
                    Log.d("Length", "secWord_TRUE: " + secWord.length() + secWord);
                    Log.d("Length", "suffix: " + suffix.length() + suffix);
                    Log.d("Length", "prefix: " + prefix.length() + prefix);
                    Log.d("Length", "---------");
                }
                else {
                    if(selectedPreset.contains("-") || selectedPreset.contains("_")){
                        selectedPreset = selectedPreset.replaceFirst("-", "");
                        selectedPreset = selectedPreset.replaceFirst("_", "");
                    }

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

                    Log.d("Preset", "presetEN: " + selectedPreset);
                    Log.d("Length", "secWord_FALSE: " + secWord.length() + secWord);
                    Log.d("Length", "suffix: " + suffix.length() + suffix);
                    Log.d("Length", "prefix: " + prefix.length() + prefix);
                    Log.d("Length", "---------");
                }
                attempts++;
            }
            if (selectedPreset.length() > 15 || selectedPreset.length() < 3) {
                Toast.makeText(MainActivity.this, "Генератор задумался. Попробуйте ещё раз", Toast.LENGTH_SHORT).show();
                selectedPreset = "Меня зовут...";
            }
        }

        return selectedPreset;
    }

    private static String removeLastVowel(String word) {
        String[] glases = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};

        char lastChar = word.charAt(word.length() - 1);

        for (String vowel : glases) {
            if (Character.toString(lastChar).equals(vowel)) {
                return word.substring(0, word.length() - 1);
            }
        }
        return word;
    }

    private void showInstructionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_instruction, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        skipButton = dialogView.findViewById(R.id.skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        rustoreButton = dialogView.findViewById(R.id.rustoreButton);
        rustoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://apps.rustore.ru/app/com.example.tarkovnicknamesgenerator";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        dialog.show();
    }
    private void animateClick(View view) {
        Animation animation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(100);
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }
}
