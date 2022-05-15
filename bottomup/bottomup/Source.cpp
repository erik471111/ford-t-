#include <iostream>
#include <vector>
#include <map>
#include <string>

using namespace std;

bool keres2(vector<string> v, string to_find) {
    for (string s : v) {
        if (s == to_find)
            return true;
    }
    return false;
}

int main() {
    vector<pair<string, string>> rules;
    string rule, key, value;
    int i;

    cout << "Add meg a szabalyokat:és a vegere ird be hogy done\n"; //bekeres
    while (cin >> rule) {//sazbályok bekérése
        if (rule == "done") //vége
            break;
        key = value = "";
        i = 0;
        while (rule[i] != '-') {
            key += rule[i];
            i++;
        }
        i += 2;
        while (i < rule.size()) {
            value += rule[i];
            i++;
        }
        rules.push_back(pair<string, string>(key, value));
    }

    cout << "\nSzabályok:\n";
    for (i = 0; i < rules.size(); i++)//végig megyünk a rulesen
        cout << rules[i].first << "->" << rules[i].second << "  Sorszám: " << i + 1 << '\n';//kiirjuk õket

    string word;//szo bekérés
    cout << "Add meg a szot ";
    cin >> word;
    cout << '\n';
    string szo2 = word;

    vector<string> folyamatlevezetese, rossz, szavak;
    vector<int> eredmeny;
    string szo = "";
    szo += szo2[0];
    folyamatlevezetese.push_back(szo);
    szavak.push_back(szo2);

    string masolat;
    bool talalt;
    std::size_t found;
    while (szavak.back().size() > 1 || folyamatlevezetese.back() != "S") {
        talalt = false;
        for (i = 0; i < rules.size(); i++) {
            found = folyamatlevezetese.back().find(rules[i].second);
            masolat = folyamatlevezetese.back();
            if (found != std::string::npos) {
                masolat.replace(found, rules[i].second.length(), rules[i].first);
                szo = szavak.back();
                szo.erase(szo.begin());
                if (!keres2(rossz, masolat + szo)) {
                    folyamatlevezetese.push_back(masolat);
                    eredmeny.push_back(i + 1);
                    szavak.push_back(szavak.back());
                    talalt = true;
                    break;
                }
            }
        }
        if (!talalt) {
            masolat = szavak.back();
            masolat.erase(masolat.begin());
            if (masolat.size() && !keres2(rossz, folyamatlevezetese.back() + masolat)) {
                folyamatlevezetese.push_back(folyamatlevezetese.back() + masolat[0]);
                eredmeny.push_back(-1);
                szavak.push_back(masolat);
            }
            else if (folyamatlevezetese.size() > 1) {
                rossz.push_back(folyamatlevezetese.back() + masolat);
                folyamatlevezetese.pop_back();
                eredmeny.pop_back();
                szavak.pop_back();
            }
            else {
                cout << "A szo nem vezethetõ le! \n";
                return 0;
            }
        }
    }

    cout << "A szo levezethetõ!\n";

    for (i = eredmeny.size() - 1; i >= 0; i--) {
        if (eredmeny[i] != -1)
            cout << eredmeny[i] << ": " << rules[eredmeny[i] - 1].first << "->" << rules[eredmeny[i] - 1].second << '\n';
    }

    return 0;
}