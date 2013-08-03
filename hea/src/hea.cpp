//============================================================================
// Name        : hea.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
using namespace std;


class Run {

	public:
		virtual void movement() {
			cout<< "Some movement";
		}
};

class SlowRun : public Run {

	public:
		 void movement() {
			 cout<< "SlowRun";
		 }
};

class FastRun : public Run {

	public:
		 void movement() {
			 cout<< "FastRun";
		 }
};

class Human {

	private:
		Run* move;
		int money;

	public:
		Human() {
			move =  new SlowRun();
		}

		void makeMove() {
			move->movement();
		}

		void setMove(Run* run) {
			move = run;
		}


};

class Duck {
	public:
		virtual void makeQuacke() = 0;
};

class WildDuck : public Duck {
	public:
		void makeQuacke() {
			cout<"Quack, quack";
		}
};

class Turkey {
public:
	virtual void makeGobble() = 0;
};

class WildTurkey : public Turkey {
	public:
		void makeGobble() {
			cout<<"Gobble, gobble";
		}
};

class DuckAdapter : public Duck {
public:
	Turkey* turkey;
	DuckAdapter(Turkey* turkey) {
		this->turkey = turkey;
	}
	void makeQuacke() {
		turkey->makeGobble();
	}
};

void testDuck(Duck* d1) {
	d1->makeQuacke();
}
class Observer {
public:
	virtual void update() = 0;
};

class FamousPerson : public Observer {
public:
	void update() {
		cout<< "Im a famous person";
	}
};

class Observerable {

public:
	virtual void addObserver(Observer &observer) = 0 ;
	virtual void notifyObservers() = 0;
};

class Agent : public Observerable {
public:

	vector<Observer*> observed;

	void addObserver(Observer &observer) {
		observed.push_back(&observer);
		cout<<"Added";
	}

	void notifyObservers() {
		for(std::vector<int>::size_type i = 0; i != observed.size(); i++) {
			observed[i]->update();
		}
	}
};

int main() {

	Agent jackBauer;
	FamousPerson brad, angelina;
	jackBauer.addObserver(brad);
	jackBauer.notifyObservers();

	Duck* duck = new WildDuck();
	Turkey* turkey = new WildTurkey();
	Duck* fakeDuck = new DuckAdapter(turkey);
	testDuck(fakeDuck);



	Human* human =  new Human();
	human->makeMove();
	human->setMove(new FastRun());
	human->makeMove();
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	cout<<"Show me the money";
	return 0;
}
