# Esercizio di esempio

Implementare la struttura dati SortedArray. La struttura dati deve permettere inserimenti e cancellazioni di elementi di tipo generico e mantenere ordinata la collezione dei dati inseriti. L'ordine degli elementi deve potere essere specificato dall'utente.

# UnitTesting

Implementare gli unit-test degli algoritmi secondo le indicazioni suggerite nel documento [Unit Testing](UnitTesting.md).

# Uso della libreria

## Implementazione

Il file `integers.txt` che potete trovare seguendo il path

    /usr/NFS/Linux/labalgoritmi/datasets/

(in laboratorio von Neumann, selezionare il disco Y) contiene 20 milioni di interi da ordinare. Gli interi sono scritti di seguito, ciascuno su una riga. *Gli interi variano su un range molto ampio* (interi a 32 bit potrebbero non essere in grado di rappresentare adeguatamente i valori contenuti nel file).

Implementare un'applicazione che, usando un `SortedArray` ordini i primi 100'000 interi contenuti nel file `integers.txt` in base a un criterio di ordinamento fornito in input (i possibili criteri di ordinamento non sono noti a priori: ad esempio, oltre agli usuali ordinamenti crescente e decrescente, potrebbero esserci ordinamenti basati sul numero di cifre nella rappresentazione decimale o binaria degli interi, ecc.).

Si misurino i tempi di risposta e si crei una breve relazione (circa una pagina) in cui si riportano i risultati ottenuti insieme a un loro commento.
