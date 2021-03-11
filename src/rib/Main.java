package rib;

import java.util.Scanner;

import rib.entity.Address;
import rib.entity.BankAccount;
import rib.entity.BankAgency;
import rib.entity.Client;
import rib.entity.CustomerAdvisors;
import rib.entity.Deposit;
import rib.service.AddressService;
import rib.service.BankAccountService;
import rib.service.BankAgencyService;
import rib.service.ClientService;
import rib.service.CustomerAdvisorsSevice;
import rib.service.DepositService;
import rib.util.HibernateUtils;
import rib.util.Warehouse;

public class Main {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws Exception {
		Address address = new Address();
		AddressService addressService = new AddressService();
		BankAccount bankAccount = new BankAccount();
		BankAccountService bankAccountService = new BankAccountService();
		BankAgency bankAgency = new BankAgency();
		BankAgencyService bankAgencyService = new BankAgencyService();
		CustomerAdvisors customerAdvisors = new CustomerAdvisors();
		CustomerAdvisorsSevice customerAdvisorsSevice = new CustomerAdvisorsSevice();
		Client client = new Client();
		ClientService clientService = new ClientService();
		DepositService depositService = new DepositService();
		Deposit deposit = new Deposit();
		Warehouse warehouse = new Warehouse();
		HibernateUtils hibernateUtils = new HibernateUtils();
		Scanner scanner = new Scanner(System.in);

		int key;
		System.out.println("\n\n1 ADMIN   2 CLIENT");
		System.out.print("Introduceti optiunea dumneavoastra: ");
		key = scanner.nextInt();
		switch (key) {
		case 1: {
			int option1;
			customerAdvisorsSevice.customerAdvisorsLogin();
			for (int i = 0; i < 50; ++i)
				System.out.println();
			warehouse.hello();
			do {
				System.out.println("\nMENIUL PRINCIPAL");
				System.out.println("1. Adresa");
				System.out.println("2. Client");
				System.out.println("3. Banca");
				System.out.println("4. Iesire");
				System.out.print("Introduceti optiunea dumneavoastra: ");
				option1 = scanner.nextInt();
				switch (option1) {
				case 1: {
					int option1_1;
					do {
						System.out.println("\nMENIU ADRESA");
						System.out.println("1. Adaugare adresa");
						System.out.println("2. Afisare adrese");
						System.out.println("3. Stergere adresa");
						System.out.println("4. Ordonare adrese");
						System.out.println("5. Actualizare adresa");
						// System.out.println("6. Cautare adresa");
						System.out.println("0. Meniul principal");
						System.out.print("Introduceti optiunea dumneavoastra: ");
						option1_1 = scanner.nextInt();
						if (option1_1 >= 1 && option1_1 <= 5)
							System.out.println();
						switch (option1_1) {
						case 1: {
							addressService.addAddress(address);
							break;
						}
						case 2: {
							System.out.println(addressService.showAllAddresses());
							break;
						}
						case 3: {
							int option1_3;
							do {
								System.out.println("1. Stergeti o anumita adresa");
								System.out.println("2. Stergeti toate adresele");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option1_3 = scanner.nextInt();
								System.out.println();
								switch (option1_3) {
								case 1: {
									addressService.deleteAddress(address);
									break;
								}
								case 2: {
									addressService.deleteAllAddresses();
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
								}
							} while (option1_3 != 0);
							break;
						}
						case 4: {
							int option1_4;
							do {
								System.out.println("1. Ordonati adresele dupa no");
								System.out.println("2. Ordonati adresele dupa judet");
								System.out.println("3. Ordonati adresele dupa oras");
								System.out.println("9. Iesire");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option1_4 = scanner.nextInt();
								System.out.println();
								switch (option1_4) {
								case 1: {
									int option1_4_1;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option1_4_1 = scanner.nextInt();
										switch (option1_4_1) {
										case 1: {
											System.out.println(addressService.orderAddressesByNoAsc());
											break;
										}
										case 2: {
											System.out.println(addressService.orderAddressesByNoDesc());
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option1_4_1 != 0);
									break;

								}
								case 2: {
									int option1_4_2;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option1_4_2 = scanner.nextInt();
										switch (option1_4_2) {
										case 1: {
											System.out.println(addressService.orderAddressesByCountyAsc());
											break;
										}
										case 2: {
											System.out.println(addressService.orderAddressesByCountyDesc());
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option1_4_2 != 0);
									break;
								}
								case 3: {
									int option1_4_3;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option1_4_3 = scanner.nextInt();
										switch (option1_4_3) {
										case 1: {
											System.out.println(addressService.orderAddressesByCityAsc());
											break;
										}
										case 2: {
											System.out.println(addressService.orderAddressesByCityDesc());
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option1_4_3 != 0);
									break;
								}
								case 9: {
									warehouse.exit();
									break;
								}
								case 0: {
									break;
								}
								default:
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
							} while (option1_4 != 0);
							break;
						}
						case 5: {
							// testeaza-------------------------
							addressService.updateAddress(address);
							break;
						}
//						case 6:{
//							System.out.println(clientService.findClientAddress());
//							break;
//						}
						case 0: {
							break;
						}
						default:
							System.err.println("Optiune introdusa invalida!");
							continue;
						}
					} while (option1_1 != 0);
					break;
				}
				case 2: {
					int option2_1;
					do {
						System.out.println("\nMENIU CLIENT");
						System.out.println("1. Adaugare client");
						System.out.println("2. Afisare clienti");
						System.out.println("3. Stergere client");
						System.out.println("4. Ordonare clienti");
						System.out.println("5. Actualizare date client");
						System.out.println("6. Cautare client");
						System.out.println("0. Meniul principal");
						System.out.print("Introduceti optiunea dumneavoastra: ");
						option2_1 = scanner.nextInt();
						switch (option2_1) {
						case 1: {
							System.err.println("\nIntroduceti datele personale");
							clientService.addClient(client);
							System.err.println("Verificare!");
							System.out.println(clientService.findClientByName());
							System.err.println("\n\nIntroduceti adresa!");
							addressService.addAddress(address);
							System.err.println("Verificare!");
							System.out.print(addressService.selectTheLastAddressCreated()+"\n");
							System.err.println("\n\nCreare contul bancar");
							bankAccountService.addBankAccount(bankAccount);
							System.err.println("\n\nCreare deposit");
							depositService.createDeposit(deposit);
							System.err.println("Verificare!");
							System.out.println(depositService.selectTheLastDepositCreated());
							bankAccountService.updateDoposit(deposit);
							System.err.println("\n\nCompletati datele finale");
							clientService.addClientBankingData(client);
							break;
						}
						case 2: {
							System.out.println(clientService.showAllClients());
							break;
						}
						case 3: {
							int option2_1_3;
							do {
								System.out.println("\n1. Stergeti client dupa id");
								System.out.println("2. Stergeti toti clientii");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_3 = scanner.nextInt();
								System.out.println();
								switch (option2_1_3) {
								case 1: {
									clientService.deleteClientById();
									break;
								}
								case 2: {
									clientService.deleteAllClients();
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.print("\nOptiune introdusa invalida!");
									continue;
								}
								}
							} while (option2_1_3 != 0);
							break;
						}
						case 4: {
							int option2_1_4;
							do {
								System.out.println("\n1. Ordonati clientii dupa no");
								System.out.println("2. Ordonati clientii dupa id");
								System.out.println("3. Ordonati clientii dupa nume");
								System.out.println("4. Ordonati clientii dupa prenume");
								System.out.println("9. Iesire");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_4 = scanner.nextInt();
								System.out.println();
								switch (option2_1_4) {
								case 1: {
									int option2_1_4_1;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option2_1_4_1 = scanner.nextInt();
										switch (option2_1_4_1) {
										case 1: {
											System.out.println(clientService.orderClientsByNoAsc());
											break;
										}
										case 2: {
											System.out.println(clientService.orderClientsByNoDesc());
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option2_1_4_1 != 0);
									break;
								}
								case 2: {
									int option2_1_4_2;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option2_1_4_2 = scanner.nextInt();
										switch (option2_1_4_2) {
										case 1: {
											System.out.println(clientService.orderClientsByIdAsc());
											break;
										}
										case 2: {
											System.out.println(clientService.orderClientsByIdDesc());
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option2_1_4_2 != 0);
									break;
								}
								case 3: {
									int option2_1_4_3;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option2_1_4_3 = scanner.nextInt();
										switch (option2_1_4_3) {
										case 1: {
											System.out.println(clientService.orderClientsByFirstNameAsc());
											break;
										}
										case 2: {
											System.out.println(clientService.orderClientsByFirstNameDesc());
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option2_1_4_3 != 0);
									break;
								}
								case 4: {
									int option2_1_4_4;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option2_1_4_4 = scanner.nextInt();
										switch (option2_1_4_4) {
										case 1: {
											System.out.println(clientService.orderClientsByLastNameAsc());
											break;
										}
										case 2: {
											System.out.println(clientService.orderClientsByLastNameDesc());
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option2_1_4_4 != 0);
									break;
								}
								case 9: {
									warehouse.exit();
									break;
								}
								case 0: {
									break;
								}
								default:
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
							} while (option2_1_4 != 0);
							break;
						}
						case 5: {
							int option2_1_5;
							do {
								System.out.println("\n1. Actualizati email-ul clientului");
								System.out.println("2. Actualizati telefonul clientului");
								System.out.println("3. Actualizati prenumele clientului");
								System.out.println("4. Actualizati numele clientului");
								System.out.println("5. Actualizati adresa clientului");
								System.out.println("9. Iesire");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_5 = scanner.nextInt();
								System.out.println();
								switch (option2_1_5) {
								case 1: {
									clientService.updateClientEmail(client);
									break;
								}
								case 2: {
									clientService.updateClientPhoneNumber(client);
									break;
								}
								case 3: {
									clientService.updateClientFirstName(client);
									break;
								}
								case 4: {
									clientService.updateClientLastName(client);
									break;
								}
								case 5: {
									clientService.updateClientAddress(client);
									break;
								}
								case 9: {
									warehouse.exit();
									break;
								}
								case 0: {
									break;
								}
								default:
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
							} while (option2_1_5 != 0);
							break;
						}
						case 6: {
							int option2_1_6;
							do {
								System.out.println("\n1. Cautati dupa nume");
								System.out.println("2. Cautati dupa CNP");
								System.out.println("3. Cautati dupa id");
								System.out.println("4. Cautati dupa cont");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_6 = scanner.nextInt();
								System.out.println();
								switch (option2_1_6) {
								case 1: {
									System.out.println(clientService.findClientByName());
									break;
								}
								case 2: {
									System.out.println(clientService.findClientByCnp());
									break;
								}
								case 3: {
									System.out.println(clientService.findClientById());
									break;
								}
								case 4: {
									System.out.println(clientService.findClientByAccount());
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
								}
							} while (option2_1_6 != 0);
							break;
						}
						case 0: {
							break;
						}
						default: {
							System.err.println("Optiune introdusa invalida!");
							continue;
						}
						}
					} while (option2_1 != 0);
					break;
				}
				case 3: {
					int option3_1;
					do {
						System.out.println("\nMENIU BANCA");
						System.out.println("1. Agentie bancara");
						System.out.println("2. Angajati");
						System.out.println("3. Depozit");
						System.out.println("0. Meniul principal");
						System.out.print("Introduceti optiunea dumneavoastra: ");
						option3_1 = scanner.nextInt();
						switch (option3_1) {
						case 1: {
							int option3_1_1;
							do {
								System.out.println("\nMENIU AGENTIE BANCARA");
								System.out.println("1. Adaugare agentie noua");
								System.out.println("2. Afisare agentii");
								System.out.println("3. Stergere agentie");
								System.out.println("4. Ordonare agentii");
								System.out.println("5. Actualizare date agentii");
								System.out.println("6. Cautare agentii");
								System.out.println("9. Iesire");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option3_1_1 = scanner.nextInt();
								if (option3_1_1 >= 1 && option3_1_1 <= 6)
									System.out.println();
								switch (option3_1_1) {
								case 1: {
									bankAgencyService.addBankAgency(bankAgency);
									break;
								}
								case 2: {
									System.out.println(bankAgencyService.showAllBankAgency());
									break;
								}
								case 3: {
									int option3_1_1_3;
									do {
										System.out.println("1. Stergeti o anumita agentie");
										System.out.println("2. Stergeti toate agentiile");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option3_1_1_3 = scanner.nextInt();
										System.out.println();
										switch (option3_1_1_3) {
										case 1: {
											addressService.deleteAddress(address);
											break;
										}
										case 2: {
											addressService.deleteAllAddresses();
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.print("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option3_1_1_3 != 0);
									break;
								}
								case 4: {
									int option3_1_1_4;
									do {
										System.out.println("1. Ordonati agentiile bancare dupa no");
										System.out.println("2. Ordonati agentiile bancare dupa id");
										System.out.println("3. Ordonati agentiile bancare dupa orele de program");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option3_1_1_4 = scanner.nextInt();
										System.out.println();
										switch (option3_1_1_4) {
										case 1: {
											int option3_1_1_4_1;
											do {
												System.out.println("1. Ascendent");
												System.out.println("2. Descendent");
												System.out.println("0. Meniul anterior");
												System.out.print("Introduceti optiunea dumneavoastra: ");
												option3_1_1_4_1 = scanner.nextInt();
												switch (option3_1_1_4_1) {
												case 1: {
													System.out.println(bankAgencyService.orderBankByNoAsc());
													break;
												}
												case 2: {
													System.out.println(bankAgencyService.orderBankByNoDesc());
													break;
												}
												case 0: {
													break;
												}
												default: {
													System.err.print("Optiune introdusa invalida!");
													continue;
												}
												}
											} while (option3_1_1_4_1 != 0);
											break;
										}
										case 2: {
											int option3_1_1_4_2;
											do {
												System.out.println("1. Ascendent");
												System.out.println("2. Descendent");
												System.out.println("0. Meniul anterior");
												System.out.print("Introduceti optiunea dumneavoastra: ");
												option3_1_1_4_2 = scanner.nextInt();
												switch (option3_1_1_4_2) {
												case 1: {
													System.out.println(bankAgencyService.orderBankByIdAsc());
													break;
												}
												case 2: {
													System.out.println(bankAgencyService.orderBankByIdDesc());
													break;
												}
												case 0: {
													break;
												}
												default: {
													System.err.print("Optiune introdusa invalida!");
													continue;
												}
												}
											} while (option3_1_1_4_2 != 0);
											break;
										}
										case 3: {
											int option3_1_1_4_3;
											do {
												System.out.println("1. Ascendent");
												System.out.println("2. Descendent");
												System.out.println("0. Meniul anterior");
												System.out.print("Introduceti optiunea dumneavoastra: ");
												option3_1_1_4_3 = scanner.nextInt();
												switch (option3_1_1_4_3) {
												case 1: {
													System.out.println(bankAgencyService.orderBankByNoAsc());
													break;
												}
												case 2: {
													System.out.println(bankAgencyService.orderBankByNoDesc());
													break;
												}
												case 0: {
													break;
												}
												default: {
													System.err.print("Optiune introdusa invalida!");
													continue;
												}
												}
											} while (option3_1_1_4_3 != 0);
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option3_1_1_4 != 0);
									break;
								}
								case 5: {
									bankAgencyService.updateBankAgency(bankAgency);
									break;
								}
								case 6: {
									int option3_1_1_6;
									do {
										System.out.println("1. Cautati dupa no");
										System.out.println("2. Cautare dupa oras");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option3_1_1_6 = scanner.nextInt();
										System.out.println();
										switch (option3_1_1_6) {
										case 1: {

											System.out.println(bankAgencyService.findBankAgencyByNo());
											break;
										}
										case 2: {
											System.out.println(bankAgencyService.findBankAgencyByCity());
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.print("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option3_1_1_6 != 0);
									break;
								}
								case 9: {
									warehouse.exit();
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.print("Optiune introdusa invalida!");
									continue;
								}
								}
							} while (option3_1_1 != 0);
							break;
						}
						case 2: {
							int option3_1_2;
							do {
								System.out.println("\nMENIU BANCHERI");
								System.out.println("1. Adaugare bancher");
								System.out.println("2. Lista bancheri");
								System.out.println("3. Stergere bancher");
								System.out.println("4. Ordonare bancheri");
								System.out.println("5. Actualizare date bancher");
								System.out.println("6. Cautare bancher");
								System.out.println("9. Iesire");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option3_1_2 = scanner.nextInt();
								if (option3_1_2 >= 1 && option3_1_2 <= 6)
									System.out.println();
								switch (option3_1_2) {
								case 1: {
									customerAdvisorsSevice.addCustomersAdvisors(customerAdvisors);
									break;
								}
								case 2: {
									System.out.println(customerAdvisorsSevice.showAll());
									break;
								}
								case 3: {
									int option3_1_2_3;
									do {
										System.out.println("1. Stergeti un anumit bancher");
										System.out.println("2. Stergeti toti angajatii");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option3_1_2_3 = scanner.nextInt();
										switch (option3_1_2_3) {
										case 1: {
											customerAdvisorsSevice.deleteCustomerAdvisors(customerAdvisors);
											break;
										}
										case 2: {
											customerAdvisorsSevice.deleteAllCustomersAdvisors();
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option3_1_2_3 != 0);
									break;
								}
								case 4: {
									int option3_1_2_4;
									do {
										System.out.println("1. Ordonati bancheri dupa nume");
										System.out.println("2. Ordonati bancheri dupa prenume");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option3_1_2_4 = scanner.nextInt();
										switch (option3_1_2_4) {
										case 1: {
											int option3_1_2_4_1;
											do {
												System.out.println("1. Ascendent");
												System.out.println("2. Descendent");
												System.out.println("0. Meniul anterior");
												System.out.print("Introduceti optiunea dumneavoastra: ");
												option3_1_2_4_1 = scanner.nextInt();
												switch (option3_1_2_4_1) {
												case 1: {
													System.out.println(customerAdvisorsSevice
															.orderCustomerAdvisorsbyFirstNameAsc());
													break;
												}
												case 2: {
													System.out.println(customerAdvisorsSevice
															.orderCustomerAdvisorsbyFirstNameDesc());
													break;
												}
												case 0: {
													break;
												}
												default: {
													System.err.println("Optiune introdusa invalida!");
													continue;
												}
												}
											} while (option3_1_2_4_1 != 0);
											break;
										}
										case 2: {
											int option3_1_2_4_2;
											do {
												System.out.println("1. Ascendent");
												System.out.println("2. Descendent");
												System.out.println("0. Meniul anterior");
												System.out.print("Introduceti optiunea dumneavoastra: ");
												option3_1_2_4_2 = scanner.nextInt();
												switch (option3_1_2_4_2) {
												case 1: {
													System.out.println(customerAdvisorsSevice
															.orderCustomerAdvisorsbyLastNameAsc());
													break;
												}
												case 2: {
													System.out.println(customerAdvisorsSevice
															.orderCustomerAdvisorsbyLastNameDesc());
													break;
												}
												case 0: {
													break;
												}
												default: {
													System.err.println("Optiune introdusa invalida!");
													continue;
												}
												}
											} while (option3_1_2_4_2 != 0);
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option3_1_2_4 != 0);
									break;
								}
								case 5: {
									customerAdvisorsSevice.updateCustomerAdvisors(customerAdvisors);
									break;
								}
								case 6: {
									int option3_1_2_6;
									do {
										System.out.println("1. Cautare dupa agentia bancara");
										System.out.println("0. Meniul anterior");
										System.out.print("Introduceti optiunea dumneavoastra: ");
										option3_1_2_6 = scanner.nextInt();
										switch (option3_1_2_6) {
										case 1: {
											System.out.println("Introduceti ID-ul bancii");
											String bankID = scanner.next();
											System.out.println(
													customerAdvisorsSevice.findCustomerAdvisorsByBankAgency(bankID));
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.println("Optiune introdusa invalida!");
											continue;
										}
										}
									} while (option3_1_2_6 != 0);
									break;
								}
								case 9: {
									warehouse.exit();
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
								}
							} while (option3_1_2 != 0);
							break;
						}
						case 3: {
							int option3_1_3;
							do {
								System.out.println("\n1. Lista depozite");
								System.out.println("2. Cautare depozit");
								System.out.println("3. Simulare - convertiti in euro si afisati soldul total");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option3_1_3 = scanner.nextInt();
								switch (option3_1_3) {
								case 1: {
									System.out.println(depositService.showAll());
									break;
								}
								case 2: {
									System.out.println(depositService.showPersonalDeposit());
									break;
								}
								case 3: {
									depositService.totalSumInEUR();
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
								}
								break;
							} while (option3_1_3 != 0);
						}
						case 0: {
							break;
						}
						default: {
							System.err.println("Optiune introdusa invalida!");
							continue;
						}
						}
					} while (option3_1 != 0);
					break;

				}
				case 4: {
					warehouse.exit();
					break;
				}
				default: {
					System.err.println("Optiune introdusa invalida!");
					continue;
				}
				}
			} while (option1 != 0);
			break;
		}

		case 2: {
			clientService.clientLogin();
			for (int i = 0; i < 50; ++i)
				System.out.println();
			warehouse.hello();
			int option2;
			do {
				System.out.println("\nMENIUL PRINCIPAL");
				System.out.println("1. Cont personal");
				System.out.println("2. Agentie bancara");
				System.out.println("3. Iesire");
				System.out.print("Introduceti optiunea dumneavoastra: ");
				option2 = scanner.nextInt();
				switch (option2) {
				case 1: {
					int option2_1;
					do {
						System.out.println("\nCONT PERSONAL");
						System.out.println("1. Depunere numerar");
						System.out.println("2. Retragere numerar");
						System.out.println("3. Vizualizare sold");
						System.out.println("4. Simulare");
						System.out.println("0. Meniul principal");
						System.out.print("Introduceti optiunea dumneavoastra: ");
						option2_1 = scanner.nextInt();
						switch (option2_1) {
						case 1: {
							int option2_1_1;
							do {
								System.out.println("\nMENIUL DE DEPUNERI");
								System.out.println("1. RON");
								System.out.println("2. EUR");
								System.out.println("3. USD");
								System.out.println("4. GBP");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_1 = scanner.nextInt();
								switch (option2_1_1) {
								case 1: {
									depositService.addRon(deposit);
									break;
								}
								case 2: {
									depositService.addEur(deposit);
									break;
								}
								case 3: {
									depositService.addUsd(deposit);
									break;
								}
								case 4: {
									depositService.addGbp(deposit);
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
								}
							} while (option2_1_1 != 0);
							break;
						}
						case 2: {
							int option2_1_2;
							do {
								System.out.println("\n MENIUL DE RETRAGERI");
								System.out.println("1. RON");
								System.out.println("2. EUR");
								System.out.println("3. USD");
								System.out.println("4. GBP");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_2 = scanner.nextInt();
								switch (option2_1_2) {
								case 1: {
									depositService.withdrawalRon(deposit);
									break;
								}
								case 2: {
									depositService.withdrawalEur(deposit);
									break;
								}
								case 3: {
									depositService.withdrawalUsd(deposit);
									break;
								}
								case 4: {
									depositService.withdrawalGbp(deposit);
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
								}
							} while (option2_1_2 != 0);
							break;
						}
						case 3: {
							System.out.println(depositService.showPersonalDeposit());
							break;
						}
						case 4: {
							int option2_1_4;
							do {
								System.out.println("\n Convertiti toti banii in:");
								System.out.println("1. RON");
								System.out.println("2. EUR");
								System.out.println("0. Meniul anterior");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_1_4 = scanner.nextInt();
								switch (option2_1_4) {
								case 1: {
									depositService.convertAllMoneyToRON();
									break;
								}
								case 2: {
									depositService.convertAllMoneyToEUR();
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
								}
							} while (option2_1_4 != 0);
							break;
						}
						case 0: {
							break;
						}
						default: {
							System.err.println("Optiune introdusa invalida!");
							continue;
						}
						}
					} while (option2_1 != 0);
					break;
				}
				case 2: {
					int option2_2;
					do {
						System.out.println("\n1. Lista agentii bancare");
						System.out.println("2. Cautare agentie bancara");
						System.out.println("0. Meniul principal");
						System.out.print("Introduceti optiunea dumneavoastra: ");
						option2_2 = scanner.nextInt();
						switch (option2_2) {
						case 1: {
							System.out.println(bankAgencyService.showAllBankAgency());
							break;
						}
						case 2: {
							int option2_2_2;
							do {
								System.out.println("\n1. Cautare dupa judet");
								System.out.println("2. Cautare dupa oras");
								System.out.println("0. Meniul principal");
								System.out.print("Introduceti optiunea dumneavoastra: ");
								option2_2_2 = scanner.nextInt();
								switch (option2_2_2) {
								case 1: {
									System.out.println(bankAgencyService.findBankAgencyByCounty());
									break;
								}
								case 2: {
									System.out.println(bankAgencyService.findBankAgencyByCity());
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("Optiune introdusa invalida!");
									continue;
								}
								}
							} while (option2_2_2 != 0);
							break;
						}
						case 0: {
							break;
						}
						default: {
							System.err.println("Optiune introdusa invalida!");
							continue;
						}
						}
					} while (option2_2 != 0);
					break;
				}
				case 3: {
					warehouse.exit();
					break;
				}
				default: {
					System.err.println("Optiune introdusa invalida!");
					continue;
				}
				}
			} while (option2 != 0);
			break;
		}
		default: {
			System.err.println("Optiune introdusa invalida!");
			break;
		}
		}

	}
}
