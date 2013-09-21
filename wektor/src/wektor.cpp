//============================================================================
// Name        : wektor.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================
#include <iostream>
#include <string.h>
using namespace std;

class osoba {
	string nazwisko;
public:
	osoba(){};
	osoba(string nazw): nazwisko(nazw){}
	friend
	ostream & operator<<(ostream &s, const osoba & o);
	friend
	ostream & operator<<(ostream &s, const osoba * wsk);

};
ostream & operator<<(ostream &s, const osoba & o) {
	s <<o.nazwisko;
	return s;
}

ostream & operator<<(ostream &s, const osoba * wsk) {
	s <<wsk->nazwisko;
	return s;
}

const int pojemnosc_wektora = 15;

class wektor {
	osoba tabl[pojemnosc_wektora];
	int ile_obiektow;
public:
	wektor() : ile_obiektow(0) {}
	int wstaw(const osoba & nowy, int gdzie = -1);
	void usun(int nr);
	osoba & co_na(int pozycja) {return tabl[pozycja];}
	friend
	ostream& operator <<(ostream & stru, wektor &x);
private:
	void rozsun(int pozycja);
	void zsun(int nr);
};
ostream& operator <<(ostream& stru, wektor& spis)
{
	stru <<"  ";
	for (int i = 0; i < spis.ile_obiektow; i++) {
		stru<<i<<")";
		stru<<endl;
		return stru;
	}
}
void wektor::rozsun(int pozycja)
{
	for(int i = ile_obiektow; i > pozycja; i--)
	{
		tabl[i] = tabl[i-1];
	}
}
void wektor::zsun(int nr)
{
	for(int i = nr; i > ile_obiektow; i++)
	{
		tabl[i] = tabl[i+1];
	}
}
int wektor::wstaw(const osoba & nowy, int gdzie)
{
	if(ile_obiektow ==  pojemnosc_wektora) {
		cout<<"wektor juz zapelniony";
	}
	if(gdzie < 0 || gdzie > ile_obiektow) {
		gdzie = ile_obiektow;
	}
	rozsun(gdzie);
	tabl[gdzie] =  nowy;
	ile_obiektow++;
	return 1;
}
void wektor::usun(int nr) {
	if( nr < ile_obiektow){
		zsun(nr);
		ile_obiektow--;
	}
}





int main() {
	wektor sa;
	osoba mozart("sasas");
	osoba bet("Saas");
	cout<<mozart;
	sa.wstaw(mozart, 0);
	sa.wstaw(bet, 1);
	cout<<sa.co_na(1);
	sa.usun(0);
	cout<<sa.co_na(0);
}
