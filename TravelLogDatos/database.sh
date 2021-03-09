#!/bin/bash


####################################################
# Modificar las siguientes constantes
# antes de ejecutar este script
# según el sitio donde se encuentre la BD.

     HOST="den1.mysql4.gear.host"
   PUERTO="3306"
  USUARIO="travellog2"
    CLAVE="Travel_01.loG"
BASEDATOS="travellog2"

#####################################################


TABLAS="travellog.sql"
VIAJES="viaje.csv"
ITINERARIO="itinerario.csv"
HITOS="hitos.csv"


echo "Creando base de datos $BASEDATOS desde cero"
echo "drop   database if exists     $BASEDATOS;" | mysql -u $USUARIO -p$CLAVE -h$HOST -P$PUERTO
echo "create database if not exists $BASEDATOS\
             default character set utf8 \
             default collate utf8_general_ci;"   | mysql -u $USUARIO -p$CLAVE -h$HOST -P$PUERTO

echo "Creando tablas desde archivo $TABLAS"
mysql -u$USUARIO -p$CLAVE -h$HOST -P$PUERTO $BASEDATOS < $TABLAS

echo "Importando datos desde archivo $VIAJES"
mysqlimport  --ignore-lines=1 \
             --fields-terminated-by=, \
             --columns='id_viaje,desc_corta,desc_larga,fec_inicio,fec_fin,participantes,medio_transporte' \
             --local -u$USUARIO -h$HOST -P$PUERTO -p$CLAVE $BASEDATOS $VIAJES 2&> /dev/null

echo "Importando datos desde archivo $ITINERARIO"
mysqlimport  --ignore-lines=1 \
             --fields-terminated-by=, \
             --columns='id_itinerario,fk_id_viaje,desc_corta,desc_larga,ruta,fecha' \
             --local -u$USUARIO -p$CLAVE -h$HOST -P$PUERTO $BASEDATOS $ITINERARIO 2&> /dev/null

echo "Importando datos desde archivo $HITOS"
mysqlimport  --ignore-lines=1 \
             --fields-terminated-by=, \
             --columns='id_hito,fk_id_itinerario,fk_id_viaje,desc_corta,desc_larga,horario_inicio,horario_fin,guia' \
             --local -u$USUARIO -p$CLAVE -h$HOST -P$PUERTO $BASEDATOS $HITOS  2&> /dev/null
 