(defn sort-idempotent?
  [coll]
  (= (sort coll) (sort (sort coll))))

(sc/quick-check 100
  (prop/for-all [coll (gen/vector gen/int)]
    (sort-idempotent? coll)))
;; {:result true, :num-tests 100, :seed 1383433754854}
