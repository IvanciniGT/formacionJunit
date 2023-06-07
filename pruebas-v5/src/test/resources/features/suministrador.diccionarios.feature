#language:es

Característica: SuministradorDeDiccionarios

    Escenario: Preguntar por un idioma que se de antemano que existe
            Dado un suministrador que tiene idioma "ES"
            Cuando le pregunto si tiene un diccionario de idioma "ES"
            Entonces me tiene que contestar que "si"

    Escenario: Preguntar por un idioma que se de antemano que no existe
            Dado un suministrador que no tiene idioma "ELFICO"
            Cuando le pregunto si tiene un diccionario de idioma "ELFICO"
            Entonces me tiene que contestar que "no"

    Escenario: Solicitar un diccionario de un idioma que se de antemano se que no existe
            Dado un suministrador que no tiene idioma "ELFICO"
            Cuando le pido un diccionario de idioma "ELFICO"
            Entonces no me tiene que devolver NADA

    Escenario: Solicitar un diccionario de un idioma que se de antemano se que SI existe
            Dado un suministrador que tiene idioma "ES"
            Cuando le pido un diccionario de idioma "ES"
            Entonces me tiene que devolver el diccionario de idioma "ES"
