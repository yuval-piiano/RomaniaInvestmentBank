package rib;

import java.util.Scanner;

import rib.entity.Address;
import rib.entity.BankAgency;
import rib.entity.Client;
import rib.entity.CustomerAdvisors;
import rib.entity.Deposit;
import rib.service.AddressService;
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
		System.out.println("Enter 1 for admin, 2 for client");
		System.out.print("Please enter your option: ");
		key = scanner.nextInt();

		switch (key) {
		case 1: {
			int option1;
			customerAdvisorsSevice.customerAdvisorsLogin();
			warehouse.hello();
			do {
				System.out.println("\nMAIN MENU");
				System.out.println("1. Address menu");
				System.out.println("2. Clienti");
				System.out.println("3. Banca");
				System.out.println("4. Exit");
				System.out.print("Please enter your option: ");
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
						System.out.println("0. Return to main menu");
						System.out.print("Please enter your option: ");
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
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
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
									System.err.println("The option entered is non-existent!");
									continue;
								}
								}
							} while (option1_3 != 0);
							break;
						}
						case 4: {
							int option1_4;
							do {
								System.out.println("1. Order address by no");
								System.out.println("2. Order address by county");
								System.out.println("3. Order address by city");
								System.out.println("9. Exit");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
								option1_4 = scanner.nextInt();
								System.out.println();
								switch (option1_4) {
								case 1: {
									int option1_4_1;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
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
											System.err.println("The option entered is non-existent!");
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
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
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
											System.err.println("The option entered is non-existent!");
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
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
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
											System.err.println("The option entered is non-existent!");
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
									System.err.println("The option entered is non-existent!");
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
						case 0: {
							break;
						}
						default:
							System.err.println("The option entered is non-existent!");
							continue;
						}
					} while (option1_1 != 0);
					break;
				}
				case 2: {
					int option2_1;
					do {
						System.out.println();
						System.out.println("MENIU CLIENT");
						System.out.println("1. Adaugare client");
						System.out.println("2. Afisare clienti");
						System.out.println("3. Stergere client");
						System.out.println("4. Ordonare clienti");
						System.out.println("5. Actualizare date client");
						System.out.println("6. Cautare client");
						System.out.println("0. Return to main menu");
						System.out.print("Please enter your option: ");
						option2_1 = scanner.nextInt();
						System.out.println();
						switch (option2_1) {
						case 1: {
							clientService.addClient(client);
							break;
						}
						case 2: {
							System.out.println(clientService.showAllClients());
							break;
						}
						case 3: {
							int option2_1_3;
							do {
								System.out.println("1. Stergeti un anumit client");
								System.out.println("2. Stergeti toti clientii");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
								option2_1_3 = scanner.nextInt();
								System.out.println();
								switch (option2_1_3) {
								case 1: {
									clientService.deleteClient();
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
									System.err.println("The option entered is non-existent!");
									continue;
								}
								}
							} while (option2_1_3 != 0);
							break;
						}
						case 4: {
							int option2_1_4;
							do {
								System.out.println("1. Order clients by no");
								System.out.println("2. Order clients by id");
								System.out.println("3. Order clients by first name");
								System.out.println("4. Order clients by last name");
								System.out.println("9. Exit");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
								option2_1_4 = scanner.nextInt();
								System.out.println();
								switch (option2_1_4) {
								case 1: {
									int option5_1;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
										option5_1 = scanner.nextInt();
										switch (option5_1) {
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
											System.err.println("The option entered is non-existent!");
											continue;
										}
										}
									} while (option5_1 != 0);
									break;
								}
								case 2: {
									int option5_2;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
										option5_2 = scanner.nextInt();
										switch (option5_2) {
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
											System.err.println("The option entered is non-existent!");
											continue;
										}
										}
									} while (option5_2 != 0);
									break;
								}
								case 3: {
									int option5_3;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
										option5_3 = scanner.nextInt();
										switch (option5_3) {
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
											System.err.println("The option entered is non-existent!");
											continue;
										}
										}
									} while (option5_3 != 0);
									break;
								}
								case 4: {
									int option5_4;
									do {
										System.out.println("1. Ascendent");
										System.out.println("2. Descendent");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
										option5_4 = scanner.nextInt();
										switch (option5_4) {
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
											System.err.println("The option entered is non-existent!");
											continue;
										}
										}
									} while (option5_4 != 0);
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
									System.err.println("The option entered is non-existent!");
									continue;
								}
							} while (option2_1_4 != 0);
							break;
						}
						case 5: {
							int option2_1_5;
							do {
								System.out.println("1. Update client email");
								System.out.println("2. Update client phone");
								System.out.println("3. Update client first name");
								System.out.println("4. Update client last name");
								System.out.println("5. Update client address");
								System.out.println("9. Exit");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
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
									System.err.println("The option entered is non-existent!");
									continue;
								}
							} while (option2_1_5 != 0);
							break;
						}
						case 6: {
							int option2_1_6;
							do {
								System.out.println("1. Find by first name");
								System.out.println("2. Find by CNP");
								System.out.println("3. Find by ID");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
								option2_1_6 = scanner.nextInt();
								System.out.println();
								switch (option2_1_6) {
								case 1: {
									System.out.print("Introduceti numele clientului cautat: ");
									String firstName = scanner.next();
									System.out.println(clientService.findClientByFirstName(firstName));
									break;
								}
								case 2: {
									System.out.print("Introduceti CNP-ul clientului cautat: ");
									int cnp = scanner.nextInt();
									System.out.println(clientService.findClientByCnp(cnp));
									break;
								}
								case 3: {
									System.out.print("Introduceti ID-ul clientului cautat: ");
									String id = scanner.next();
									System.out.println(clientService.findClientById(id));
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("The option entered is non-existent!");
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
							System.err.println("The option entered is non-existent!-------");
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
						System.out.println("0. Return to main menu");
						System.out.print("Please enter your option: ");
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
								System.out.println("9. Exit");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
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
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
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
											System.err.print("The option entered is non-existent!");
											continue;
										}
										}
									} while (option3_1_1_3 != 0);
									break;
								}
								case 4: {
									int option3_1_1_4;
									do {
										System.out.println("1. Order bank agency by no");
										System.out.println("2. Order bank agency by id");
										System.out.println("3. Order bank agency by operating hours");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
										option3_1_1_4 = scanner.nextInt();
										System.out.println();
										switch (option3_1_1_4) {
										case 1: {
											int option3_1_1_4_1;
											do {
												System.out.println("1. Ascendent");
												System.out.println("2. Descendent");
												System.out.println("0. Return to previous menu");
												System.out.print("Please enter your option: ");
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
													System.err.print("The option entered is non-existent!");
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
												System.out.println("0. Return to previous menu");
												System.out.print("Please enter your option: ");
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
													System.err.print("The option entered is non-existent!");
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
												System.out.println("0. Return to previous menu");
												System.out.print("Please enter your option: ");
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
													System.err.print("The option entered is non-existent!");
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
											System.err.println("The option entered is non-existent!");
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
										System.out.println("1. Find by no");
										System.out.println("2. Find by city");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
										option3_1_1_6 = scanner.nextInt();
										System.out.println();
										switch (option3_1_1_6) {
										case 1: {
											int no;
											System.out.print("Introduceti numarul agentiei pe care o cautati: ");
											no = scanner.nextInt();
											System.out.println(bankAgencyService.findBankAgencyByNo(no));
											break;
										}
										case 2: {
											String city;
											System.out.print("Introduceti orasul in care doriti sa cautati: ");
											city = scanner.next();
											System.out.println(bankAgencyService.findBankAgencyByCity(city));
											break;
										}
										case 0: {
											break;
										}
										default: {
											System.err.print("The option entered is non-existent!");
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
									System.err.print("The option entered is non-existent!");
									continue;
								}
								}
							} while (option3_1_1 != 0);
							break;
						}
						case 2: {
							int option3_1_2;
							do {
								System.out.println("\nMENIU ANGAJATI BANCA");
								System.out.println("1. Adaugare angajat");
								System.out.println("2. Afisare angajati");
								System.out.println("3. Stergere angajat");
								System.out.println("4. Ordonare angajati");
								System.out.println("5. Actualizare date angajat");
								System.out.println("6. Cautare angajat");
								System.out.println("9. Exit");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
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
										System.out.println("1. Stergeti un anumit angajat");
										System.out.println("2. Stergeti toti angajatii");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
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
											System.err.println("The option entered is non-existent!");
											continue;
										}
										}
									} while (option3_1_2_3 != 0);
									break;
								}
								case 4: {
									int option3_1_2_4;
									do {
										System.out.println("1. Order customer advisors by first name");
										System.out.println("2. Order customer advisors by last name");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
										option3_1_2_4 = scanner.nextInt();
										switch (option3_1_2_4) {
										case 1: {
											int option3_1_2_4_1;
											do {
												System.out.println("1. Ascendent");
												System.out.println("2. Descendent");
												System.out.println("0. Return to previous menu");
												System.out.print("Please enter your option: ");
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
													System.err.println("The option entered is non-existent!");
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
												System.out.println("0. Return to previous menu");
												System.out.print("Please enter your option: ");
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
													System.err.println("The option entered is non-existent!");
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
											System.err.println("The option entered is non-existent!");
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
										System.out.println("1. Find by bank agency");
										System.out.println("0. Return to previous menu");
										System.out.print("Please enter your option: ");
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
											System.err.println("The option entered is non-existent!");
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
									System.err.println("The option entered is non-existent!");
									continue;
								}
								}
							} while (option3_1_2 != 0);
							break;
						}
						default: {
							System.err.println("The option entered is non-existent!");
							continue;
						}
						case 0: {
							break;
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
					System.err.println("The option entered is non-existent!");
					continue;
				}
				}
			} while (option1 != 0);
			break;
		}

		case 2: {
			// clientService.clientLogin();
			System.out.println("Ai reusit sa te autentifici ca si client!");
			warehouse.hello();
			int option2;
			do {
				System.out.println("\nMAIN MENU");
				System.out.println("1. Personal account");
				System.out.println("2. Bank agency");
				System.out.println("3. Exit");
				System.out.print("Please enter your option: ");
				option2 = scanner.nextInt();
				switch (option2) {
				case 1: {
					int option2_1;
					do {
						System.out.println("1. Cash deposits");
						System.out.println("2. Withdrawal");
						System.out.println("3. Vizualizare sold");
						System.out.println("0. Return to main menu");
						System.out.print("Please enter your option: ");
						option2_1 = scanner.nextInt();
						switch (option2_1) {
						case 1: {
							int option2_1_1;
							do {
								System.out.println("\nMENU OF CASH DEPOSITS");
								System.out.println("1. Ron");
								System.out.println("2. Euro");
								System.out.println("3. USD");
								System.out.println("4. GBP");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
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
									System.err.println("The option entered is non-existent!");
									continue;
								}
								}
							} while (option2_1_1 != 0);
							break;
						}
						case 2: {
							int option2_1_2;
							do {
								System.out.println("\n MENU OF WITHDRAWALS");
								System.out.println("1. Ron");
								System.out.println("2. Euro");
								System.out.println("3. USD");
								System.out.println("4. GBP");
								System.out.println("0. Return to previous menu");
								System.out.print("Please enter your option: ");
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
									System.err.println("The option entered is non-existent!");
									continue;
								}
								}
							} while (option2_1_2 != 0);
							break;
						}
						case 3: {
							System.out.print("Enter the password: ");
							int password = scanner.nextInt();
							System.out.println(depositService.showPersonalDeposit(password));
							break;
						}
						case 0: {
							break;
						}
						default: {
							System.err.println("The option entered is non-existent!");
							continue;
						}
						}
					} while (option2_1 != 0);
					break;
				}
				case 2: {
					int option2_2;
					do {
						System.out.println("1. Banking agencies list");
						System.out.println("2. Search banking agencies");
						System.out.println("0. Return to main menu");
						System.out.print("Please enter your option: ");
						option2_2 = scanner.nextInt();
						switch (option2_2) {
						case 1: {
							System.out.println(bankAgencyService.showAllBankAgency());
							break;
						}
						case 2: {
							int option2_2_2;
							do {
								System.out.println("1. Search by county");
								System.out.println("2. Search by city");
								System.out.println("0. Return to main menu");
								System.out.print("Please enter your option: ");
								option2_2_2 = scanner.nextInt();
								switch (option2_2_2) {
								case 1: {
									System.out.print("Please enter the county: ");
									String county = scanner.next();
									System.out.println(bankAgencyService.findBankAgencyByCounty(county));
									break;
								}
								case 2: {
									System.out.print("Please enter the city: ");
									String city = scanner.next();
									System.out.println(bankAgencyService.findBankAgencyByCity(city));
									break;
								}
								case 0: {
									break;
								}
								default: {
									System.err.println("The option entered is non-existent!");
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
							System.err.println("The option entered is non-existent!");
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
					System.err.println("The option entered is non-existent!");
					continue;
				}
				}
			} while (option2 != 0);
			break;
		}
		default: {
			System.err.println("The option entered is non-existent!");
			break;
		}
		}

	}
}
