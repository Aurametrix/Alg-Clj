(defn shell-sort [xs]
  (let [l (count xs)
        max-h (loop [h 0]
                (let [t (+ 1 (* h 3))]
                  (if (> t l) h (recur t))))]
    (loop [xt xs h max-h]   
      (if (= h 0) xt        
        (recur (loop [xq xt start 0]
                 (if (= start h) xq              
                   (recur (loop [xp xq this (+ start h)]
                            (if (>= this l) xp  
                              (recur (let [tv (xp this)
                                           i (loop [prev (- this h)]
                                               (if (< prev start) start
                                                 (if (< (xp prev) tv) (+ prev h)
                                                   (recur (- prev h)))))]
                                       (if (= i this) xp                                 
                                         (loop [xo xp curr this prev (- curr h)]
                                           (if (< prev i) (assoc xo i tv)
                                             (recur (assoc xo curr (xo prev)) 
                                                    (- curr h) (- prev h)))))  
                                       ) (+ this h))))
                          (+ start 1)))) 
               (/ (- h 1) 3))))    
    ))

