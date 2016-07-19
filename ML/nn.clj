(require '[synaptic.core :refer :all])

(def trset (load-training-set "mnist10k"))   ; load MNIST training set
(def net (mlp [784 100 10]             ; net with 784 inputs, 100 hidden units
              [:sigmoid :softmax]      ; and 10 (softmax) outputs
              (training :backprop)))   ; to be trained with backpropagation

(train net trset 10)              ; train the network for 10 epochs (returns a future)
@*1                               ; (deref to wait for the future to complete)

(-> @net :training :stats)        ; show training statistics
