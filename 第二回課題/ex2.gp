#2018/07.ex2.gp
set term png enhanced size 640,480
set output "task1.png"
set title "graph" font "Helvetica,30"
set xlabel "num"
set ylabel "ms"
set xrange[0:500000]
set yrange[0:500000]
plot "insertion.txt"t "intsretion" w lp, "MergeSort.txt"t "merge" w lp,"quicksort.txt"t "quick" w lp, "selctionsort.txt"t "selction" w lp
set term aqua