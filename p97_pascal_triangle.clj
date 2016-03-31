;; License: BSD 2-Clause https://opensource.org/licenses/BSD-2-Clause

;; 4Clojure Question 97
;;
;; Pascal's triangle is a triangle of numbers computed using the following rules:
;; - The first row is 1.
;; - Each successive row is computed by adding together adjacent numbers in the row
;;   above, and adding a 1 to the beginning and end of the row.
;; Write a function which returns the nth row of Pascal's Triangle.
;; http://en.wikipedia.org/wiki/Pascal%27s_triangle

(defn pasc-next-row
  "Return then next Pascal triangle row given the previous one"
  [prev-row]
  (concat [1]
          (map + (take (dec (count prev-row)) prev-row) (rest prev-row))
          [1]))

(defn -pasc [n]
  (if (= n 1)
    [1]
    (pasc-next-row (-pasc (dec n)))))

(def pasc (memoize -pasc))


(and
 (= (pasc 1) [1])

 (= (map pasc (range 1 6))
    [
         [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]

     ])

 (= (pasc 11)
    [1 10 45 120 210 252 210 120 45 10 1]))
