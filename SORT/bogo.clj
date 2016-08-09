(defn in-order? [order xs]
  (or (empty? xs) 
      (apply order xs)))
 
(defn bogosort [order xs]
  (if (in-order? order xs) xs
    (recur order (shuffle xs))))
