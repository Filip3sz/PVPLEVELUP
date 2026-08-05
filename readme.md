<h1>PVPLEVELUP - MINECRAFT GAME MODE</h1>
<p>
  This is a custom game mode developed by me in 2023 using <b>Java</b> on the <b>Spigot</b> engine 1.8. Inspired by the classic game mode from the legendary <b>HIPLAY.PL</b> server.
</p>

<h2>Game Rules</h2>
<p>
  Compact <b>100x100</b> block arena designed for continuous, fast-paced combat.<br>
  Every kill <b>instantly levels up</b> the player and automatically upgrades their loadout.<br>
  Death resets the player's progress back to Level 1, forcing a fresh start.<br>
  Each level unlocks a <b>unique kit</b> – the higher your level, the more powerful equipment you earn.
</p>

<h2>Tech Stack</h2>
<p>
  <b>Language:</b> Java 8 (JDK 1.8)<br>
  <b>API / Engine:</b> Spigot API 1.8.8<br>
  <b>Build Tool:</b> Maven<br>
</p>

<h2>Architecture & Technical Solutions</h2>
<p>
  <b>1. Progression Engine & Kit Tiering</b><br>
  Tracks player levels directly through Bukkit's internal structure (<code>p.setLevel()</code>) and delegates loadout updates to dedicated methods (<code>level1()</code> – <code>level10()</code>). Each level-up automatically wipes current inventory, clears active potion effects, and grants an upgraded kit tailored to the new rank.
</p>
<p>
  <b>2. Kill Detection & Level-Up Distribution</b><br>
  Listens for player death events and immediately triggers the <code>levelUp()</code> sequence for the killer. The system evaluates current progress, increments the level by 1, and equips higher-tier gear (swords, snowballs, golden apples, diamond armor) up to the maximum threshold (Level 10).
</p>
<p>
  <b>3. Hard Reset System Upon Death</b><br>
  When a player dies, all accumulated progress is immediately cleared. The <code>levelStartAfterDeath()</code> method resets the level to 1, restores full health and hunger, enforces Survival mode, and applies the basic starter kit (leather armor and wooden sword).
</p>
<p>
  <b>4. Global Broadcasts & Screen Titles</b><br>
  Integrated notification service (<code>UtilManager</code>) delivers personalized title/subtitle screen overlays directly to the player. Every tier progression is broadcast globally in chat (<code>Bukkit.broadcastMessage</code>), with special announcements reserved for reaching the maximum level.
</p>
<p>
  <b>5. Max Level Cap & Safeguards</b><br>
  A boundary cap at Level 10 prevents index out-of-bounds issues and redundant calculations once maximum progression is reached. Players retain top-tier diamond equipment and golden apples on subsequent kills without breaking progression logic.
</p>
<p>
  <b>6. Player State Sanitization</b><br>
  Prior to applying any new kit, the engine automatically resets fire duration (<code>setFireTicks(0)</code>), strips active potion effects (<code>removePotionEffect</code>), and flushes all inventory slots and armor contents (<code>setArmorContents(null)</code>).
</p>

<h2>Installation & Configuration</h2>
<p>
  <b>1. Prerequisites</b><br>
  • <b>Java 8 (JDK / JRE 1.8)</b> runtime environment.<br>
  • A Minecraft server running on <b>Spigot 1.8.8</b> or <b>(recommended)</b> <a href="https://papermc.io/downloads/all" target="_blank">PaperSpigot 1.8.8</a>.
</p>
<p>
  <b>2. Building & Moving the Plugin</b><br>
  • Compile the project using <code>mvn clean package</code> or obtain the built artifact.<br>
  • Locate the generated <code>Filipesz-PVPLEVELUP-0.0.1.jar</code> file inside the <code>target/</code> directory.<br>
  • Move the <code>.jar</code> file into your Minecraft server's <code>plugins/</code> folder.
</p>
<p>
  <b>3. Execution & Verification</b><br>
  Start or restart your Minecraft server.<br>
</p>

<hr>

<h1>PVPLEVELUP - TRYB DO GRY MINECRAFT</h1>
<p>
  Jest to tryb napisany przeze mnie w 2023 roku w języku <b>Java</b> na silniku <b>Spigot</b> 1.8. Inspirowany dawnym trybem na legendarnym serwerze <b>HIPLAY.PL</b>
</p>

<h2>Zasady rozgrywki</h2>
<p>
  Niewielka arena o wymiarach <b>100x100</b> bloków, wymuszająca ciągłą i dynamiczną walkę.<br>
  Każde zabójstwo to <b>natychmiastowy awans</b> na wyższy poziom i automatyczne ulepszenie ekwipunku.<br>
  Śmierć resetuje postęp gracza do 1 poziomu, zmuszając do rozpoczęcia walki od nowa.<br>
  Każdy poziom oferuje <b>unikalny zestaw</b> – im wyższy level, tym potężniejszy ekwipunek zdobywasz.
</p>

<h2>Stos Technologiczny</h2>
<p>
  <b>Język:</b> Java 8 (JDK 1.8)<br>
  <b>API / Silnik:</b> Spigot API 1.8.8<br>
  <b>Narzędzie budowania:</b> Maven<br>
</p>

<h2>Architektura i Rozwiązania Techniczne</h2>
<p>
  <b>1. Silnik Progresji i Zestawów (Progression Engine & Kit Tiering)</b><br>
  Przechowuje poziom gracza bezpośrednio w strukturze silnika Bukkit (<code>p.setLevel()</code>) oraz odwołuje się do dedykowanych metod (<code>level1()</code> – <code>level10()</code>). Każdy awans automatycznie czyści dotychczasowy ekwipunek, usuwa aktywne efekty mikstur i przydziela odświeżony zestaw uzbrojenia dostosowany do poziomu.
</p>
<p>
  <b>2. Dystrybucja Awansów i Detektor Zabójstw (Kill Detection & LevelUp)</b><br>
  Nasłuchuje zdarzeń śmierci graczy i natychmiastowo wyzwala metodę <code>levelUp()</code> dla zabójcy. Mechanizm przelicza aktualny poziom, zwiększa go o 1 i nakłada wyższy tier przedmiotów (m.in. miecze, śnieżki, złote jabłka, pancerz diamentowy), aż do osiągnięcia maksymalnego limitu (Level 10).
</p>
<p>
  <b>3. System Twardego Resetu po Śmierci (Hard Reset System)</b><br>
  W momencie zgonu gracz natychmiastowo traci cały wywalczony postęp. Metoda <code>levelStartAfterDeath()</code> zeruje level do wartości 1, przywraca pełne zdrowie oraz głód, ustawia tryb Survival i nakłada podstawowy, skórzano-drewniany zestaw startowy.
</p>
<p>
  <b>4. Komunikacja i Rozgłoszenia Globalne (Broadcast & Screen Titles)</b><br>
  Zintegrowany system powiadomień <code>UtilManager</code> przesyła spersonalizowane komunikaty ekranowe (Title/Subtitle) bezpośrednio do gracza. Każdy awans jest również rozgłaszany globalnie na czacie (<code>Bukkit.broadcastMessage</code>), ze specjalnym wyróżnieniem dla gracza, który zdobędzie maksymalny poziom.
</p>
<p>
  <b>5. Kontrola Limitu Poziomów (Max Level Cap & Safeguards)</b><br>
  Zabezpieczenie na poziomie 10 blokuje dalszą kalkulację statystyk po osiągnięciu maksymalnego tieru. Gracz utrzymuje najwyższej klasy ekwipunek diamentowy i złote jabłka przy kolejnych zabójstwach, nie powodując błędów indeksowania ani braku kolejnych zestawów.
</p>
<p>
  <b>6. Sanitizacja i Porządkowanie Stanu Postaci (Player State Sanitization)</b><br>
  Przed nadaniem każdego nowego zestawu system automatycznie resetuje czas płonięcia (<code>setFireTicks(0)</code>), usuwa wszelkie aktywne efekty mikstur (<code>removePotionEffect</code>) oraz całkowicie czyści zawartość ekwipunku i slotów pancerza (<code>setArmorContents(null)</code>).
</p>

<h2>Instalacja i Konfiguracja</h2>
<p>
  <b>1. Wymagania Wstępne</b><br>
  • Środowisko uruchomieniowe <b>Java 8 (JDK / JRE 1.8)</b>.<br>
  • Serwer Minecraft działający na silniku <b>Spigot 1.8.8</b> lub <b>(zalecane)</b> <a href="https://papermc.io/downloads/all" target="_blank">PaperSpigot 1.8.8</a>.
</p>
<p>
  <b>2. Budowanie i Przenoszenie Pliku</b><br>
  • Skompiluj projekt za pomocą komendy <code>mvn clean package</code> lub pobierz gotowy artefakt.<br>
  • Zlokalizuj wygenerowany plik <code>Filipesz-PVPLEVELUP-0.0.1.jar</code> w katalogu <code>target/</code>.<br>
  • Przenieś plik <code>.jar</code> do katalogu <code>plugins/</code> na Twoim serwerze Minecraft.
</p>
<p>
  <b>3. Uruchomienie i Weryfikacja</b><br>
  Uruchom lub zrestartuj serwer Minecraft.
</p>