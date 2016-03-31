;; License: BSD 2-Clause https://opensource.org/licenses/BSD-2-Clause

;; 4Clojure Question 44
;;
;; Write a function which can rotate a sequence in either direction.


(defn rotate-pos [n coll]
  (flatten
   (reduce
    (fn [acc elem]
      (if (<= n (count (flatten acc)))
        (list (concat (first acc) (list elem)) (second acc))
        (list (first acc) (concat (second acc) (list elem)))
        ))
    '(() ())
    coll)))

(defn rotate [n coll]
  (let [len (count coll)]
    (cond
      (> n len) (rotate-pos (- n len) coll)
      (and (neg? n) (> (Math/abs n) len)) (rotate (+ len n) coll)
      (neg? n) (rotate-pos (+ len n) coll)
      :else (rotate-pos n coll)
      )))

(and
 (= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2))

 (= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3))

 (= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1))

 (= (rotate 1 '(:a :b :c)) '(:b :c :a))

 (= (rotate -4 '(:a :b :c)) '(:c :a :b)))
