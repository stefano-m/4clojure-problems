;; License: BSD 2-Clause https://opensource.org/licenses/BSD-2-Clause

;; 4Clojure Question 43
;;
;; Write a function which reverses the interleave process into
;; x number of subsequences.


(defn reverse-interleave [coll n]
  (let [len (count coll)]
    (reduce
     (fn [acc elem]
       (cons
        (map #(nth coll % nil)
             (range elem len n))
        acc))
     nil
     (reverse (range n)))))

(and
 (= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

 (= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))

 (= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))
