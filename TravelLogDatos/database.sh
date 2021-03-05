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

# echo "Importando datos desde archivo $MODULOS"
# mysqlimport  --ignore-lines=1 \
#              --fields-terminated-by=, \
#              --columns='profesor_id,siglas,nombre,curso,ciclo,horas_totales,horas_semanales,num_resultados,r1_peso,r2_peso,r3_peso,r4_peso,r5_peso,r6_peso,r7_peso,r8_peso,r9_peso' \
#              --local -u$USUARIO -p$CLAVE -h$HOST -P$PUERTO $BASEDATOS $MODULOS  2&> /dev/null
 
# echo "Importando datos desde archivo $MODULOS_ALUMNOS"
# mysqlimport  --ignore-lines=1 \
#              --fields-terminated-by=, \
#              --columns='modulo_id,alumno_id,r1,r2,r3,r4,r5,r6,r7,r8,r9' \
#              --local -u$USUARIO -p$CLAVE -h$HOST -P$PUERTO $BASEDATOS $MODULOS_ALUMNOS 2&> /dev/null
