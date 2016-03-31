;; License: BSD 2-Clause https://opensource.org/licenses/BSD-2-Clause

;; 4Clojure Question 95
;;
;; Write a predicate which checks whether or not a given sequence represents a
;; binary tree. Each node in the tree must have a value, a left child, and a right
;; child.
;; http://en.wikipedia.org/wiki/Binary_tree

;; bintree: a node can be either '(value left-node right-node) or nil
;; 1st element cannot be a sequence
;; 2nd & 3rd elements must be a node

(defn binary-tree? [t]
  (if (nil? t)
    true
    (and (coll? t)
         (= 3 (count t))
         (not (coll? (first t)))
         (every? binary-tree? (rest t)))))

(and
 (= (binary-tree? '(:a (:b nil nil) nil))
    true)

 (= (binary-tree? '(:a (:b nil nil)))
    false)

 (= (binary-tree? [1 nil [2 [3 nil nil] [4 nil nil]]])
    true)

 (= (binary-tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])
    false)

 (= (binary-tree? [1 [2 [3 [4 nil nil] nil] nil] nil])
    true)

 (= (binary-tree? [1 [2 [3 [4 false nil] nil] nil] nil])
    false)

 (= (binary-tree? '(:a nil ()))
    false))
