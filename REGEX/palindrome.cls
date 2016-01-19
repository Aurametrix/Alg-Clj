;; this code turns numbers into a list of characters that need to be turned back
;; (defn palindrome? [s]
;;   (= s (apply str (reverse s))))

(defn palindrome? [num]
  (= (seq (str num)) (clojure.string/reverse (str num))))
  
