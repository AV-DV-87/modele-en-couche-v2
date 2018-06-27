
    
    <form method="post">
		<c:if test="${not empty client}">
			<input type="hidden" name="id" value="${client.id}" />
		</c:if>
		<div>
			<label for="name">Nom :</label>
			<input id="name" name="name" value="${not empty client ? client.name : '' }" />
		</div>
		<button>Valider</button>
	</form>