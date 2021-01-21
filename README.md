# Gestiunea-stocurilor-de-medicamente

Proiectul reprezintă o aplicație pentru gestiunea stocurilor de medicamente ale farmaciilor din diferite orașe. 
Limbajul de programare folosit este Java, Swing(un serviciu de API pentru interfete grafice care se integrează foarte bine cu Java)
pentru realizarea mai timpurie a UI-ului.
Cunoașterea aplicațiilor/frameworkurilor J2EE, Java Server Faces, MyBatis, Hibernate, Apache, Spring ar fi ușurat procesul
de development si ar fi asigurat hostarea aplicatiei pe un domeniu online, însă nu am avut experienta necesară de lucru cu acestea.
Aplicația prelucrează datele existente într-o bază de date SQLITE, care a fost integrată proiectului prin driverul jdbc.

Folosim o bază de date relațională pentru că având contextul unei ierarhii de clase bine stabilită și structurată, cu relații foarte clare
între obiectele sale, ne este mult mai simplu să reprezentăm această ierarhie prin intermediul a ceva mai organizat, care ne oferă
posibiltatea scrierii relațiilor între entitățile noastre, așa cum o face o bază de date relațională.
După stabilirea concretă a relațiilor care există între obiecte noastre, tot procesul de dezvoltare devine unul mai simplu.

IDE-ul folosit este Intellij datorită capacităților sale de development remarcabil.
Aplicatia prezintă următoarele functionalități:
- afisarea tuturor farmaciilor dintr-un anumit oras (ex: Timisoara: Farmacia Vlad, Farmacia Dona, Farmacia Operei)
- afisarea tuturor farmaciilor care au pe stoc un anumit medicament (ex: Nurofen: Farmacia Dona Iasi, Farmacia Catena Cluj, Farmacia Dristor Bucuresti)
- afisarea cantitatilor totale pentru un medicament selectat dintr-un anumit oras (ex: Algocalmin Cluj: 1000 bucati).

Aplicația prezintă avantaje reale în cadrul managementului farmaciilor și poate fi dezvoltată până în pragul de a deveni disponibilă posibililor clienți. 
