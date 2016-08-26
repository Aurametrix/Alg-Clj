(defn selection-sort
  [input]
  (let [ixs (vec (range (count input)))
        min-key-from (fn [acc ix] (apply min-key acc (subvec ixs ix)))
        swap (fn [coll i j] (assoc coll i (coll j) j (coll i)))]
    (reduce
     (fn [acc ix] (swap acc ix (min-key-from acc ix))) input ixs)))
