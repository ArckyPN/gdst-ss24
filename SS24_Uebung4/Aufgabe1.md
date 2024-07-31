# 1a) Anweisungsüberdeckung

Beispiel 1: Input: zeichen = 'b', alphabet = ['a', 'c']

- erstes = 0
- letztes = 2 - 1 = 1
- while Iteration 1 ( 0 <= 1 ):
  - mitte = 0 + (( 1 - 0 ) / 2) = 0
  - alphabet[0] = 'a'
  - if 'a' < 'b':
    - erstes = 0 + 1 = 1            // Rechts weitersuchen
- while Iteration 2 ( 1 <= 1 ):
  - mitte = 1
  - alphabet[1] = 'c'
  - if 'c' > 'b':
    - letztes = 1 - 1 = 0           // Links weitersuchen
- break while ( 1 <= 0 )
- return -1                         // Zeichen nicht gefunden

Beispiel 2: Input: zeichen = 'b', alphabet = ['a', 'b', 'c']

- erstes = 0
- letztes = 3 - 1 = 2
- - while Iteration 1 ( 0 <= 2 ):
  - mitte = 0 + (( 2 - 0 ) / 2) = 1
  - alphabet[1] = 'b'
  - else ( 'b' == 'b' ):
    - return 1                      // Zeichen gefunden


# 1b) Entscheinungsüberdeckung

Beispiel 1: Input: zeichen = 'b', alphabet = ['a', 'c']

- erstes = 0
- letztes = 2 - 1 = 1
- while Iteration 1 ( 0 <= 1 ):             // while true
  - mitte = 0 + (( 1 - 0 ) / 2) = 0
  - alphabet[0] = 'a'
  - if 'a' < 'b':                           // if x < y true
    - erstes = 0 + 1 = 1            
- while Iteration 2 ( 1 <= 1 ):    
  - mitte = 1
  - alphabet[1] = 'c'
  - if 'c' > 'b':                           // if x > y true
    - letztes = 1 - 1 = 0           
- break while ( 1 <= 0 )                    // while false
- return -1                  

Beispiel 2: Input: zeichen = 'b', alphabet = ['a', 'b', 'c']

- erstes = 0
- letztes = 3 - 1 = 2
- - while Iteration 1 ( 0 <= 2 ):  
  - mitte = 0 + (( 2 - 0 ) / 2) = 1
  - alphabet[1] = 'b'
  - else ( 'b' == 'b' ):                    // if else
    - return 1                   

# 1c) def-use-Ketten

- zeichen:
  1. [zeichen, final char zeichen, if (alphabet[mitte] < zeichen)]
  2. [zeichen, final char zeichen, else if (alphabet[mitte] > zeichen)]
- alphabet:
  1. [alphabet, final char[] alphabet, int letztes = alphabet.length - 1]
  2. [alphabet, final char[] alphabet, if (alphabet[mitte] < zeichen)]
  3. [alphabet, final char[] alphabet, else if (alphabet[mitte] > zeichen)]
- erstes:
  1. [erstes, int erstes = 0, while (erstes <= letztes)]
  2. [erstes, int erstes = 0, final int mitte = erstes + ((letztes - erstes) / 2)]
  3. [erstes, erstes = mitte + 1, while (erstes <= letztes)]
  4. [erstes, erstes = mitte + 1, final int mitte = erstes + ((letztes - erstes) / 2)]
- letztes:
  1. [letztes, int letztes = alphabet.length - 1, while (erstes <= letztes)]
  2. [letztes, int letztes = alphabet.length - 1, final int mitte = erstes + ((letztes - erstes) / 2)]
  3. [letztes, letztes = mitte - 1, while (erstes <= letztes)]
  4. [letztes, letztes = mitte - 1, final int mitte = erstes + ((letztes - erstes) / 2)]
- mitte:
  1. [mitte, final int mitte = erstes + ((letztes - erstes) / 2), if (alphabet[mitte] < zeichen)]
  2. [mitte, final int mitte = erstes + ((letztes - erstes) / 2), erstes = mitte + 1]
  3. [mitte, final int mitte = erstes + ((letztes - erstes) / 2), else if (alphabet[mitte] > zeichen)]
  4. [mitte, final int mitte = erstes + ((letztes - erstes) / 2), letztes = mitte - 1]
  5. [mitte, final int mitte = erstes + ((letztes - erstes) / 2), return mitte]


# 1d) def-use-Ketten-Überdeckung

selbe Beispiele wir a), diese Beispiele decken bereits alle Fälle ab und damit alle def-use Ketten
