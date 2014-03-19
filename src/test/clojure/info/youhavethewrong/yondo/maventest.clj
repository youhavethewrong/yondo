(ns info.youhavethewrong.yondo.maventest
  (:use info.youhavethewrong.yondo.maven)
  (:use clojure.test))

(def die (info.youhavethewrong.yondo.DiceRoll.))

(deftest
  test-maven-msg
  (is (= (exclaim)
         "Yes, I wrote Clojure in Emacs and tested it with Maven!")))

(deftest
  test-dice-roll
  (is (< (first (. die roll "2d6"))
         13)))
