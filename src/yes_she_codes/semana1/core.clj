(ns yes-she-codes.semana1.core
  (:require [yes_she_codes.semana1.logic :as y.logic]
            [yes_she_codes.semana1.db :as y.db])
  (:use clojure.pprint))

(defn teste
  []
  (let [clientes (y.db/lista-clientes)
        cartoes (y.db/lista-cartoes)
        compras (y.db/lista-compras)]

    (println "Total gasto em todo o perido:" (y.logic/total-gasto compras))
    (println)
    (println "Compras feitas no estabelecimento Alura:") (pprint (y.logic/buscar-compras-por-estabelecimento "Alura" compras))
    (println)
    (println "Compras feitas no mês 02:") (pprint (y.logic/buscar-compras-mes 2 compras))
    (println)
    (println "Total gasto no mês 02:" (y.logic/total-gasto-no-mes 2 compras))
    (println)
    (println "Compras entre os valores de 10 e 40:") (pprint (y.logic/compras-por-intervalo-de-valor 40 10 compras))
    (println)
    (println "Compras agrupadas por estabelecimento:") (pprint (y.logic/gastos-agrupados-por-categoria compras))))

(teste)