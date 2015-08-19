/*
 * FILE:    starWarsFamilyTree.pl
 * AUTHOR:  Brittany Postnikoff
 * DATE:    2015-03-26
 * PURPOSE: Answers queries about familial relationships in the Star Wars
 *            universe.
 */

/*
 * Various predicates to explain the nature of relationships
 *   bound by blood within this universe.
 */
/* Ancestor is defined in a way that states someone is an 
 *   ancestor only if they are directly up a family tree.
 * Example: parents, grandparents, greatgrandparents.
 *   Does not take into account aunts, uncles, cousins, etc.
 * Ancestor requires 
 */
ancestor(X,Y):-parent(X,Y).
ancestor(X,Y):-parent(X,Z),ancestor(Z,Y).
aunt(X,Y):-sibling(X,Z), parent(Z,Y), female(X).
/*non-blood aunt*/
aunt(X,Y):-son(Y,Z), brotherInLaw(Z,X), female(X).
aunt(X,Y):-son(Y,Z), sisterInLaw(Z,X), female(X).
aunt(X,Y):-daughter(Y,Z), brotherInLaw(Z,X), female(X).
aunt(X,Y):-daughter(Y,Z), sisterInLaw(Z,X), female(X).
brother(X,Y):-sibling(X,Y), male(X), X \= Y.
child(X,Y):-daughter(X,Y).
child(X,Y):-son(X,Y).
cousin(X,Y):-mother(Z,X),aunt(Z,Y).
cousin(X,Y):-father(Z,X),uncle(Z,Y).
daughter(X,Y):-parent(Y,X), female(X).
father(X,Y):-parent(X,Y), male(X).
grandChild(X,Y):-daughter(Z,Y), mother(Z,X).
grandChild(X,Y):-son(Z,Y), father(Z,X).
grandDaughter(X,Y):-grandChild(X,Y), female(X).
grandFather(X,Z):-father(X,Y), parent(Y,Z).
grandMother(X,Z):-mother(X,Y), parent(Y,Z).
grandParent(X,Z):-parent(X,Y), parent(Y,Z).
grandSon(X,Y):-grandChild(X,Y), male(X).
halfBrother(X,Y):-halfSibling(X,Y), male(X).
halfSibling(X,Y):-father(Z,X), father(Z,Y), mother(A,X), mother(B,Y), X \= Y, A \= B.
halfSibling(X,Y):-father(A,X), father(B,Y), mother(Z,X), mother(Z,Y), X \= Y, A \= B.
halfSister(X,Y):-halfSibling(X,Y), female(X).
mother(X,Y):-parent(X,Y), female(X).
nephew(X,Y):-aunt(Y,X), male(X).
nephew(X,Y):-uncle(Y,X), male(X).
niece(X,Y):-aunt(Y,X), female(X).
niece(X,Y):-uncle(Y,X), female(X).
sibling(X,Y):-father(Z, X), father(Z, Y), mother(A,X), mother(A,Y), X \= Y.
sister(X,Y):-sibling(X,Y), female(X), X \= Y.
son(X,Y):-parent(Y,X), male(X).
uncle(X,Y):-parent(Z,Y), sibling(X,Z), male(X).
/*non-blood uncle*/
uncle(X,Y):-son(Y,Z), brotherInLaw(Z,X), male(X).
uncle(X,Y):-son(Y,Z), sisterInLaw(Z,X), male(X).
uncle(X,Y):-daughter(Y,Z), brotherInLaw(Z,X), male(X).
uncle(X,Y):-daughter(Y,Z), sisterInLaw(Z,X), male(X).

/*
 * Various predicates to explain the nature of relationships
 *   bound by social means within this universe.
 */
adoptedDaughter(X,Y):-adopted(Y,X), female(X).
adoptiveFather(X,Y):-adopted(X,Y), male(X).
adoptiveMother(X,Y):-adopted(X,Y), female(X).
adoptedSon(X,Y):-adopted(Y,X), male(X).
brotherInLaw(X,Y):-spouse(Z,Y), brother(X,Z).
daughterInLaw(X,Y):-daughter(Z,Y), wife(X,Z).
daughterInLaw(X,Y):-son(Z,Y), wife(X,Z).
exHusband(X,Y):-wed(X,Y), divorced(X,Y), male(X).
exHusband(X,Y):-wed(X,Y), divorced(Y,X), male(X).
exHusband(X,Y):-wed(Y,X), divorced(X,Y), male(X).
exHusband(X,Y):-wed(Y,X), divorced(Y,X), male(X).
exWife(X,Y):-wed(X,Y), divorced(X,Y), female(X).
exWife(X,Y):-wed(X,Y), divorced(Y,X), female(X).
exWife(X,Y):-wed(Y,X), divorced(X,Y), female(X).
exWife(X,Y):-wed(Y,X), divorced(Y,X), female(X).
fatherInLaw(X,Y):-husband(Z,Y), father(X,Z).
fatherInLaw(X,Y):-wife(Z,Y), father(X,Z).
husband(X,Y):-married(X,Y), male(X).
married(X,Y):-wed(X,Y).
married(X,Y):-wed(Y,X).
motherInLaw(X,Y):-husband(Z,Y), mother(X,Z).
motherInLaw(X,Y):-wife(Z,Y), mother(X,Z).
sisterInLaw(X,Y):-spouse(Z,Y), sister(X,Z).
sonInLaw(X,Y):-daughter(Z,Y),husband(X,Z).
sonInLaw(X,Y):-son(Z,Y),husband(X,Z).
spouse(X,Y):-married(X,Y), \+ divorced(X,Y), \+divorced(Y,X).
stepBrother(X,Y):-stepFather(Z,Y), son(X,Z).
stepBrother(X,Y):-stepMother(Z,Y), son(X,Z).
stepFather(X,Y):-wed(X,Z), parent(Z,Y), male(X), \+parent(X,Y), X \= Y.
stepMother(X,Y):-wed(X,Z), parent(Z,Y), female(X), \+parent(X,Y), X \= Y.
stepSister(X,Y):-stepFather(Z,Y), daughter(X,Z).
stepSister(X,Y):-stepMother(Z,Y), daughter(X,Z).
widow(X,Y):-married(X,Y), female(X), dead(Y), \+ dead(X).
widower(X,Y):-married(X,Y), male(X), dead(Y), \+ dead(X).
wife(X,Y):-married(X,Y), female(X).	

/*Related Predicates*/
related(X,Y):-ancestor(Y,X).
related(X,Y):-ancestor(X,Y).
related(X,Y):-sibling(X,Y).
related(X,Y):-sibling(X,Z), father(Z,Y).
related(X,Y):-sibling(X,Z), mother(Z,Y).
/*related(X,Y):-cousin(X,Y).*/
related(X,Y):-parent(Z,X), sibling(W,Z), daughter(Y,W).
related(X,Y):-parent(Z,X), sibling(W,Z), son(Y,W).
related(X,Y):-parent(Z,X), sibling(Y,Z).

/* printfam does not require a variable to print out information,
 *   but will not print out all descendants in groups. Providing a 
 *   variable will print all of the descendants of a single person.
 * Will print false if the person does not have descendants.
 * Printfam only takes into consideration blood descendents. A person gained 
 *   through marriage is not considered a descendent.
 */
printfam(X):-ancestor(X,Y), write(Y), write(' is a descendent of '), write(X), write('.'), nl, fail.

/*
 * Prints out all of the individuals related to a specific person.
 */
printRelated(X):-related(X,Y), write(X), write(' is related to '), write(Y), write('.'), nl, fail.

/*
 * A few additive liberties regarding facts 
 *   were made for complexity of the system.
 */
adopted(bailOrgana, leiaOrgana).
adopted(brehaOrgana, leiaOrgana).
adopted(owenLars, lukeSkywalker).
adopted(beruLars, lukeSkywalker).

dead(anakinSkywalker).
dead(beruLars).
dead(clieggLars).
dead(owenlars).
dead(padmeAmidala).
dead(shmiSkywalker).

divorced(shmiSkywalker, unknownMale).

female(beruLars).
female(brehaOrgana).
female(jainaSolo).
female(jobalNaberrie).
female(leiaOrgana).
female(maraJade).
female(padmeAmidala).
female(shmiSkywalker).
male(anakinSkywalker).
male(anakinSolo).
male(bailOrgana).
male(benSkywalker).
male(clieggLars).
male(hanSolo).
male(jacenSolo).
male(lukeSkywalker).
male(owenLars).
male(ruweeeNaberrie).
male(unknownMale).

parent(anakinSkywalker,lukeSkywalker).
parent(anakinSkywalker,leiaOrgana).
parent(clieggLars, owenLars).
parent(hanSolo, anakinSolo).
parent(hanSolo, jacenSolo).
parent(hanSolo, jainaSolo).
parent(jobalNaberrie, padmeAmidala).
parent(leiaOrgana, anakinSolo).
parent(leiaOrgana, jacenSolo).
parent(leiaOrgana, jainaSolo).
parent(lukeSkywalker, benSkywalker).
parent(maraJade, benSkywalker).
parent(padmeAmidala,lukeSkywalker).
parent(padmeAmidala,leiaOrgana).
parent(ruweeeNaberrie, padmeAmidala).
parent(shmiSkywalker, anakinSkywalker).

wed(anakinSkywalker, padmeAmidala).
wed(bailOrgana, brehaOrgana).
wed(clieggLars, shmiSkywalker).
wed(leiaOrgana,hanSolo).
wed(lukeSkywalker, maraJade).
wed(ruweeeNaberrie, jobalNaberrie).
wed(shmiSkywalker, unknownMale).
