<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Suppression d'un contact</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="SupprimerContact">
                <fieldset>
                    <legend>Supprimer un contact</legend>
    
                    <label for="nomContact">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomContact" name="nomContact" value="" size="20" maxlength="20" />
                    <br />

                </fieldset>
                <input type="submit" value="Valider"  />
            </form>
        </div>
    </body>
</html>