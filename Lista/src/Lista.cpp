//============================================================================
// Name        : Lista.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

template <class typ>
class lista {
	struct wezel {
		typ* wskObj;
		wezel* nastepca;
		wezel() : nastepca(NULL), wskObj(NULL) {}
	};

	wezel *pierwszyW;
	wezel *ostatniW;
	wezel *wybranyW;

public:
	lista() {
		pierwszyW = wybranyW = ostatniW = NULL;
	}
	~lista();

	void wstaw(typ & obj);
	typ & co_na_wybranym() {
		return *(wybranyW->wskObj);
	}

	void na_poczatek() {
		wybranyW = pierwszyW;
	}

	void na_koniec() {
		wybranyW = NULL;
	}

	wezel * przejdz_na_nastepny() {
		return (wybranyW = wybranyW->nastepca);
	}

	friend
	ostream & operator<<(ostream & stru, lista<typ>& x);

private:
	wezel* poprzedni_wezel(wezel* odnosny);

	void daje_na_poczatek(wezel* nowyW);
	void daje_na_srodek(wezel* nowyW);
	void daje_na_koniec(wezel* nowyW);

	void usuwam_pierwszy();
	void usuwam_ostatni();
	void usuwam_ze_srodka();
};


int main() {
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	return 0;
}
