Run:
```
find * -name "*.java" > sources.txt
javac -d . @sources.txt
java avaj.simulator.Simulator scenario.txt 
```
