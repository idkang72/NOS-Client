package net.waglewagle.nos.article;

import junit.framework.TestCase;
import net.waglewagle.nos.INdslArticle;
import net.waglewagle.nos.QueryResult;

public class ArticleSearcherTest extends TestCase {
	private final static String baseUrl = "http://openapi.ndsl.kr/itemsearch.do";
	private final static String keyValue = "08702579";

	public void testQuery() {
		ArticleSearcher searcher = new ArticleSearcher(keyValue, baseUrl);

		QueryResult<ArticleInputData, INdslArticle> result = searcher.query("김치 재료 숙성");

		printQueryResult(result);
	}

	private void printQueryResult(QueryResult<ArticleInputData, INdslArticle> result) {

		System.out.printf("총검색건수: %d%n", result.getTotalCount());
		System.out.printf("검색어  : %s%n", result.getInputData().getQuery());
		System.out.printf("검색대상: %s%n", result.getInputData().getTarget());
		for (INdslArticle article : result) {
			System.out.printf("%20s: %s %s%n", article.getCN(), article.getDatabaseCode(), article.getTitle());
			//System.out.printf("%20s  %s%n", "", article.getLinkForDesktop());
		}
	}

	public void testQuery2() {
		ArticleSearcher searcher = new ArticleSearcher(keyValue, baseUrl);

		QueryResult<ArticleInputData, INdslArticle> result = searcher.queryAll("LED", ArticleDatabaseType.DIKO, 1, 101);

		printQueryResult(result);
	}

	private final static String [][] bios = {
			{ "120000002900" , "Janibacter terrae"                             },
			{ "120000000522" , "Bangiadulcis atropurpurea"                     },
			{ "120000002117" , "Phoenicurus ochruros"                          },
			{ "120000000050" , "Codium yezoens"                                },
			{ "120000007040" , "Achnanthes koreana"                            },
			{ "120000005301" , "Staurastrum coarctatum"                        },
			{ "120000007973" , "Chasea magna"                                  },
			{ "120000008202" , "Albatrellus caeruleoporus"                     },
			{ "120000011893" , "Phragmidium brevipedunculatum"                 },
			{ "120000009841" , "Leucocoprinus straminellus"                    },
			{ "120000012139" , "Puccinia festucae"                             },
			{ "120000012499" , "Stagonospora petasitidis"                      },
			{ "120000017294" , "Orthostethus sieboldi"                         },
			{ "120000015356" , "Chaetocnema koreana"                           },
			{ "120000015743" , "Phyllotreta humilis"                           },
			{ "120000020342" , "Pseudoplandria sakuradanii"                    },
			{ "120000021725" , "Chlorops oryzae"                               },
			{ "120000022520" , "Nasiternella varinervis"                       },
			{ "120000029555" , "Myrmica koreana"                               },
			{ "120000024852" , "Uroleucon seneciocola"                         },
			{ "120000025171" , "Empoasca diversa"                              },
			{ "120000031153" , "Athalia proxima"                               },
			{ "120000035700" , "Apatura iris"                                  },
			{ "120000037167" , "Italochrysa japonica"                          },
			{ "120000038610" , "Oxyethira datra"                               },
			{ "120000038758" , "Plectrocnemia wui"                             },
			{ "120000040001" , "Pseudostomella koreana"                        },
			{ "120000052055" , "Asahinea chrysantha"                           },
			{ "120000051944" , "Limaria hirasei"                               },
			{ "120000051126" , "Corycaeus crassiusculus"                       },
			{ "120000051131" , "Onychocorycaeus agilis"                        },
			{ "120000055783" , "Eponides procerus"                             },
			{ "120000054709" , "Barbilophozia attenuata"                       },
			{ "120000053825" , "Pohlia sphagnicola"                            },
			{ "120000058779" , "Pteragogus flagellifer"                        },
			{ "120000058808" , "Davidijordania poecilimon"                     },
			{ "120000057588" , "Microphysogobio longidorsalis"                 },
			{ "120000014119" , "Anthrenus flavipes subsp. flavipes"            },
			{ "120000016852" , "Sitona obsoletus subsp. obsoletus"             },
			{ "120000004927" , "Cosmarium contractum var. ellipsoideum for. minus" },
			{ "120000009479" , "Cortinarius elatior var. microporus"           },
			{ "120000058812" , "Lycodes japonicus"                             },
			{ "120000060488" , "Morus mongolica"                               },
			{ "120000060498" , "Boehmeria platanifolia"                        },
			{ "120000014612" , "Coreocarabus fraterculus subsp. fraterculus"   }
	};

	public void testQuery3() {
		ArticleSearcher searcher = new ArticleSearcher(keyValue, baseUrl);

		StringBuilder buff = new StringBuilder();
		for (int i = 0; i < bios.length; i++) {
			String ktsn   = bios[i][0];
			String scfcNm = bios[i][1];

			String value = scfcNm.replaceFirst(" ", " /w0 ")
						.replaceAll(" (subsp.|var.|for.) ", " /w1 ");

			buff.delete(0, buff.length())
				.append("(TI:").append(value)
				.append(") or (AB:").append(value).append(")");

			String query = buff.toString();

			System.out.println(query);

			ArticleInputData inputData = new ArticleInputData();

			inputData.setStartPosition(1);
			inputData.setDisplayCount(5);
			inputData.setQuery(query);
			inputData.setTarget(ArticleDatabaseType.ARTI);


			QueryResult<ArticleInputData, INdslArticle> result = searcher.query(inputData);

			System.out.printf("%s: %s%n", ktsn, scfcNm, query);
			printQueryResult(result);
			System.out.println("---------------------------------------------------------\n");
		}
	}

	private final static String [][] bios2 = {
			{ "120000004350" , "Tetraëdron regulare var. incus"               },
			{ "120000004374" , "Oocystis natans var. major"                   },
			{ "120000004580" , "Scenedesmus longus var. dispar"               },
			{ "120000004605" , "Scenedesmus quadricauda var. quadrispina"     },
			{ "120000005523" , "Scenedesmus subspicatus var. bicaudatus"      },
			{ "120000005000" , "Cosmarium lundellii var. ellipticum"          },
			{ "120000005081" , "Cosmarium quadrum var. minus"                 },
			{ "120000005110" , "Cosmarium speciosum var. rostafinskii"        },
			{ "120000004872" , "Pleurotaenium trabecula for. clavata"         },
			{ "120000005318" , "Staurastrum furcigerum for. eustephanum"      },
			{ "120000013463" , "Phacus longicauda var. major"                 },
			{ "120000053563" , "Fissidens bryoides var. ramosissimus"         },
			{ "120000053645" , "Dicranum viride var. hakkodense"              },
			{ "120000054175" , "Cratoneuron commutatum var. sulcatum"         },
			{ "120000060395" , "Corydalis remota for. linearis"               },
			{ "120000060179" , "Anemone reflexa var. lineiloba"               },
			{ "120000060278" , "Ranunculus trichophyllus var. kadzusensis"    },
			{ "120000060295" , "Thalictrum rochebrunianum var. grandisepalum" },
			{ "120000060451" , "Ulmus davidiana var. japonica"                },
			{ "120000061418" , "Vaccinium uliginosum for. depressum"          },
			{ "120000060678" , "Kochia scoparia var. littorea"                },
			{ "120000060751" , "Dianthus superbus var. alpestris"             },
			{ "120000062326" , "Viscum album for. rubroauranticum"            },
			{ "120000062815" , "Gentiana zollgeri for. albiflora"             },
			{ "120000061398" , "Rhododendron mucronulatum var. taquetii"      },
			{ "120000061411" , "Vaccinium hirtum var. koreanum"               },
			{ "120000064524" , "Carex okamotoi for. variegata"                },
			{ "120000005368" , "Staurastrum punctulatum var. pygmaeum"        },
			{ "120000005376" , "Staurastrum sexcostatum var. productum"       },
			{ "120000061673" , "Saxifraga laciniata var. takedana"            },
			{ "120000061788" , "Potentilla stolonifera var. quelpaertensis"   },
			{ "120000061911" , "Rubus hirsutus var. xanthoarpus"              },
			{ "120000005254" , "Euastrum spinulosum var. inermius"            },
			{ "120000006079" , "Aulacoseira italica var. tenuissima"          },
			{ "120000062240" , "Daphne pseudomezereum var. koreana"           },
			{ "120000007530" , "Navicula rhynchocephala var. tenua"           },
			{ "120000062519" , "Acer pseudosieboldianum var. nudicarpum"      },
			{ "120000062607" , "Geranium onaei var. glabrescens"              },
			{ "120000007831" , "Nitzschia frustulum var. oblonga"             },
			{ "120000063139" , "Scutellaria indica var. tsusimensis"          },
			{ "120000006830" , "Synedra amphicephala var. austriaca"          },
			{ "120000006857" , "Synedra puichella var. lanceoiata"            },
			{ "120000006718" , "Fragilaria capucina var. mesolepta"           },
			{ "120000006753" , "Fragilaria virescens var. oblongella"         },
			{ "120000006943" , "Eunotia famelica var. littoralis"             },
			{ "120000063901" , "Eupatorium makinoi var. oppositifolium"       },
			{ "120000064082" , "Saussurea umbrosa var. herbicola"             },
			{ "120000064445" , "Carex forficula var. scabrida"                },
			{ "120000007099" , "Amphora angusta var. okamurae"                },
			{ "120000064804" , "Bromus tectorum var. glabratus"               },
			{ "120000007672" , "Pleurosigma aestuarii var. intermedia"        },
			{ "120000064865" , "Dimeria ornithopoda var. robusta"             },
			{ "120000009547" , "Entoloma nigroviolaceum var. striatulum"      },
			{ "120000004412" , "Chlorella saccharophila var. ellipsoidea"     },
			{ "120000007935" , "Surirella biseriata var. constricta"          },
			{ "120000007961" , "Rhoicosphenia curvata var. genuina"           },
			{ "120000011306" , "Fusarium bulbigenum var. nelumbicolum"        },
			{ "120000062506" , "Acer mono var. savatieri"                     },
			{ "120000060995" , "Tilia amurensis for. grosserrata"             }
	};

	private final static String [][] bios3 = {
			{ "120000058269" , "Dasycottus"         },
			{ "120000058271" , "Dasycottus sp"     },
			{ "120000059265" , "Pleuronichthys"     },
			{ "120000059267" , "Pleuronichthys sp" }
	};

	public void testQuery4() {
		ArticleSearcher searcher = new ArticleSearcher(keyValue, baseUrl);

		StringBuilder buff = new StringBuilder();
		for (int i = 0; i < bios3.length; i++) {
			String ktsn   = bios3[i][0];
			String scfcNm = bios3[i][1];

			String value = scfcNm.replaceAll(" +(subsp\\.|var\\.|for\\.) +", "#/w1#")
					.replaceAll(" +", " & ")
					.replaceAll("#", " ");

			buff.delete(0, buff.length())
				.append("(TI:").append(value)
				.append(") or (AB:").append(value).append(")");

			String query = buff.toString();

			System.out.println(query);

			ArticleInputData inputData = new ArticleInputData();

			inputData.setStartPosition(1);
			inputData.setDisplayCount(5);
			inputData.setQuery(query);
			inputData.setTarget(ArticleDatabaseType.ARTI);


			QueryResult<ArticleInputData, INdslArticle> result = searcher.query(inputData);

			if ( result.getTotalCount() <= 0 ) continue;

			System.out.printf("%s: %s%n", ktsn, scfcNm, query);
			printQueryResult(result);
			System.out.println("---------------------------------------------------------\n");
		}
	}


	public void testQuery5() {
		ArticleSearcher searcher = new ArticleSearcher(keyValue, baseUrl);

		StringBuilder buff = new StringBuilder();
		//String name  = "Solar Sail Trajectory Design for Transferring Heliocentric Fixed Displaced Orbit";
		//String value = "Solar /w0 (Sail /w1 Design)";
		//String value = "(Ulmus /w0 davidiana) & japonica";
		//String value = "김치 /n0 (발효 /n2 효과)";
		//String value = "Helicobacter /w0 (pylori /w0 urease)";
		//String value = "Metabolism /w0 of /w0 alpha-tocopherol /w0 and /w0 the /w0 isolation /w0 of /w0 a /w0 nontocopherol-reducing /w0 substance /w0 from /w0 animal /w0 tissues";

		String [] values = {
				//"Solar /n0 Sail /n1 Design",
				//"Solar /w0 Sail /w1 Design",
				//"(Solar /w0 Sail) /w1 Design",
				//"Solar /w0 (Sail /w1 Design)"
				//"Solar & Sail & Design & Development",
				//"Solar /w0 Sail /w1 Design /w1 Development",
				//"(Solar /w0 Sail) /w1 Design /w1 Development",
				//"Solar /w0 (Sail /w1 Design) /w1 Development",
				//"Solar /w0 Sail /w1 (Design /w1 Development)",
				//"(Solar /w0 Sail) /w1 (Design /w1 Development)",
				//"Solar /w0 (Sail /w1 Design /w1 Development)",
				//"Solar /w0 ((Sail /w1 Design) /w1 Development)",
				//"Solar /w0 (Sail /w1 (Design /w1 Development))"
				//"Plasmodium malariae",
				//"Plasmodium & malariae",
				//"Plasmodium /w0 malariae",
				//"Plasmodium /n0 malariae",
				"Epinephelus awoara",
				"Epinephelus & awoara",
				"Epinephelus /n0 awoara",
				"Epinephelus /w0 awoara"
		};

		for (String value : values) {
			buff.delete(0, buff.length())
				.append("(TI:").append(value).append(")");
				//.append(" | (AB:").append(value).append(")");

			String query = buff.toString();


			System.out.println(query);

			ArticleInputData inputData = new ArticleInputData();

			inputData.setStartPosition(1);
			inputData.setDisplayCount(100);
			inputData.setQuery(query);
			inputData.setTarget(ArticleDatabaseType.ARTI);


			QueryResult<ArticleInputData, INdslArticle> result = searcher.query(inputData);

			System.out.printf("%s%n", value);
			printQueryResult(result);
		}
	}


	public void testQuery6() {
		ArticleSearcher searcher = new ArticleSearcher(keyValue, baseUrl);

		String value = "Absorption of zinc phosphide particles";

		String query = value.replaceAll("[ :;,]+", " /w0 ");

		StringBuilder buff = new StringBuilder();
		buff.delete(0, buff.length())
			.append("(TI:").append(query).append(")");


		ArticleInputData inputData = new ArticleInputData();

		inputData.setStartPosition(1);
		inputData.setDisplayCount(100);
		inputData.setQuery(query);
		inputData.setTarget(ArticleDatabaseType.ARTI);


		QueryResult<ArticleInputData, INdslArticle> result = searcher.query(inputData);

		printQueryResult(result);
	}
}
