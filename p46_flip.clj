;; License: BSD 2-Clause https://opensource.org/licenses/BSD-2-Clause

;; 4Clojure Question 46
;;
;; Write a higher-order function which flips the order of the arguments of
;; an input function.

(defn flip-fn [f]
  (fn [a b]
    (f b a)))

(defn flip-w-reader [f]
  #(f %2 %1))

(and
 (= 3 ((flip-fn nth) 2 [1 2 3 4 5]))

 (= true ((flip-fn >) 7 8))

 (= 4 ((flip-w-reader quot) 2 8))

 (= [1 2 3] ((flip-fn take) [1 2 3 4 5] 3)))
