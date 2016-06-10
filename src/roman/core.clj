(ns roman.core
  (:gen-class))

(defn valid-roman? [roman]
  (clojure.set/subset? (set (seq roman)) (set (seq "MDCLXVI"))))

(defn roman2arabic [roman]
  (if (and (not (clojure.string/blank? roman)) (valid-roman? roman))
    (->> (reverse roman)
         (replace (zipmap "MDCLXVI" [1000 500 100 50 10 5 1]))
         (partition-by identity)
         (map (partial apply +))
         (reduce #(if (< %1 %2) (+ %1 %2) (- %1 %2))))))

(defn -main [& args]
  (println "TODO: Add argument parsing"))
