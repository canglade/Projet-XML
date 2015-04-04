<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un contact</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="CreationContact">
                <fieldset>
                    <legend>Informations contact</legend>
    
                    <label for="nomContact">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomContact" name="nomContact" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomContact">Prénom <span class="requis">*</span></label>
                    <input type="text" id="prenomContact" name="prenomContact" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailContact">Adresse email</label>
                    <input type="email" id="emailContact" name="emailContact" value="" size="20" maxlength="60" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>