package org.sam.converter_demo.model;

public enum Country {	
	SA("Arabia Saudita", "Riyal", 0.26610),
	DZ("Argelia", "Dinar", 0.00730),
	AR("Argentina", "Peso", 0.00560),
	AU("Australia", "Dólar", 0.67795),
	BS("Bahamas", "Dólar", 1.00000),
	BB("Barbados", "Dólar", 0.50000),
	BZ("Belice", "Dólar", 0.50000),
	BM("Bermudas", "Dólar", 1.00000),
	BO("Bolivia", "Boliviano", 0.14480),
	BR("Brasil", "Real", 0.18920),
	CA("Canadá", "Dólar", 0.73770),
	CL("Chile", "Peso", 0.00117),
	CN("China", "Yuan continental", 0.14496),
	CO("Colombia", "Peso", 0.20616),
	KP("Corea del Sur", "Won", 0.79340),
	CR("Costa Rica", "Colón", 0.00169),
	CU("Cuba", "Peso", 0.04170),
	DK("Dinamarca", "Corona", 0.14343),
	EC("Ecuador", "Dólar", 1.00000),
	EG("Egipto", "Libra", 0.04040),
	SV("El Salvador", "Colón", 0.11430),
	AE("Emiratos Árabes Unidos", "Dirham", 0.27230),
	US("Estados Unidos de América", "Dólar", 1.00000),
	RU("Federación Rusa", "Rublo", 0.01381),
	FJ("Fiyi", "Dólar", 0.45110),
	PH("Filipinas", "Peso", 0.01794),
	GB("Gran Bretaña", "Libra esterlina", 1.20270),
	GT("Guatemala", "Quetzal", 0.12740),
	GY("Guyana", "Dólar", 0.00478),
	HN("Honduras", "Lempira", 0.04050),
	HK("Hong Kong", "Dólar", 0.12814),
	HU("Hungría", "Florín", 0.00266),
	IN("India", "Rupia", 0.01210),
	ID("Indonesia", "Rupia", 0.06421),
	IQ("Irak", "Dinar", 0.00069),
	IL("Israel", "Shekel", 0.28348),
	JM("Jamaica", "Dólar", 0.00660),
	JP("Japón", "Yen", 0.00757),
	KE("Kenia", "Chelín", 0.00810),
	KW("Kuwait", "Dinar", 3.26710),
	MY("Malasia", "Ringgit", 0.22710),
	MA("Marruecos", "Dirham", 0.09560),
	NI("Nicaragua", "Córdoba", 0.02740),
	NG("Nigeria", "Naira", 0.00217),
	NO("Noruega", "Corona", 0.10140),
	NZ("Nueva Zelanda", "Dólar", 0.63230),
	PA("Panamá", "Balboa", 1.00000),
	PY("Paraguay", "Guaraní", 0.13620),
	PE("Perú", "Sol", 0.26241),
	PL("Polonia", "Esloti", 0.22780),
	PR("Puerto Rico", "Dólar", 1.00000),
	CZ("República Checa", "Corona", 0.04416),
	ZA("Sudáfrica", "Rand", 0.05876),
	DO("República Dominicana", "Peso", 0.01780),
	RO("Rumania", "Leu", 0.21570),
	SG("Singapur", "Dólar", 0.74540),
	SE("Suecia", "Corona", 0.09592),
	CH("Suiza", "Franco", 1.08060),
	TH("Tailandia", "Baht", 0.02893),
	TW("Taiwán", "Nuevo dólar", 0.03254),
	TT("Trinidad y Tobago", "Dólar", 0.14730),
	TR("Turquía", "Lira", 0.05342),
	UA("Ucrania", "Hryvnia", 0.02710),
	EU("Unión Monetaria Europea", "Euro", 1.06665),
	UY("Uruguay", "Peso", 0.02510),
	VE("Venezuela", "Bolívar digital", 0.05915),
	VN("Vietnam", "Dong", 0.04231);
	
	private String country;
	private String coin;
	private Double equivalence;
	
	private Country(String country, String coin, Double equivalence) {
		this.country = country;
		this.coin = coin;
		this.equivalence = equivalence;		
	}

	public String getCountry() {
		return country;
	}

	public String getNameCoin() {
		return coin;
	}

	public Double getEquivalence() {
		return equivalence;
	}	
}
