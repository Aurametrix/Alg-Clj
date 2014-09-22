(def split-words (clojure.string/split words-to-count #"\s"))

(defn record-word-count [memo word]
  (assoc memo word (inc (memo word 0))))

(defn count-words [words-to-count]
  (reduce record-word-count {} words-to-count))

(count-words split-words)
; {"one" 1, "fish" 4, "two" 1, "red" 1, "blue" 1}
