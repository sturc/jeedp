package de.dhbw.mosbach.dp.jeeps;

public class MitarbeiterAssembler {

	public MitarbeiterDTO writeDTO(Mitarbeiter subject) {
		MitarbeiterDTO dto = new MitarbeiterDTO();
		if (subject != null) {
			dto.setPersnr(subject.getPersnr());
			dto.setNachname(subject.getNachname());
			dto.setVorname(subject.getVorname());
		}
		return dto;
	}


	public Mitarbeiter writeMitarbeiter(MitarbeiterDTO subject) {
		if (subject != null) {
			return new Mitarbeiter(subject.getPersnr(), subject.getVorname(), subject.getNachname());
		} else {
			return new Mitarbeiter(0, null, null);
		}
	}

}
